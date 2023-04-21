package back;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.BlockingDeque;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    private DBUtilAdmin dbUtilAdmin;
    private final String dbURL = "jdbc:mysql://localhost:3306/blood_stations?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=CET";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            dbUtilAdmin = new DBUtilAdmin(dbURL);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        String username = request.getParameter("usernameInput");
        String password = request.getParameter("passwordInput");

        dbUtilAdmin.setName(username);
        dbUtilAdmin.setPassword(password);

        if (validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_view.jsp");

            List<BloodStation> bloodStationList = null;
            BloodStatus bloodStatus = null;

            try {
                bloodStationList = dbUtilAdmin.getStations();
                bloodStatus = dbUtilAdmin.getStatus();
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("BLOOD_STATIONS_LIST", bloodStationList);
            request.setAttribute("BLOOD_STATUS", bloodStatus);

            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
            dispatcher.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            String command = request.getParameter("command");

            if(command == null) {
                command = "LIST";
            }

            switch (command) {
                case "LIST":
                    showBloodStatusAndBloodStations(request, response);
                    break;
                case "ADD":
                    addBloodStation(request, response);
                    break;
                case "LOAD":
                    loadBloodStation(request, response);
                    break;
                case "UPDATE":
                    updateBloodStation(request, response);
                    break;
                case "DELETE":
                    deleteBloodStation(request, response);
                    break;
                case "UPDATE_STATUS":
                    updateBloodStatus(request, response);
                    break;
                case "LOAD_STATUS":
                    loadBloodStatus(request, response);
                    break;
                default:
                    showBloodStatusAndBloodStations(request, response);
            }

            } catch (Exception e) {
                throw new ServletException(e);
            }
    }

    private void deleteBloodStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("bloodStationID");

        dbUtilAdmin.deleteBloodStation(id);

        showBloodStatusAndBloodStations(request, response);
    }

    private void updateBloodStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("bloodStationID"));
        String stationName = request.getParameter("nameInput");
        String city = request.getParameter("cityInput");
        String zipCode = request.getParameter("zipCodeInput");
        String street = request.getParameter("streetInput");
        int buildingNumber = Integer.parseInt(request.getParameter("buildingNumberInput"));
        String phoneNumber = request.getParameter("phoneNumberInput");
        String email = request.getParameter("emailInput");
        String website = request.getParameter("websiteInput");

        BloodStation bloodStation = new BloodStation(id, stationName, city, zipCode, street, buildingNumber,
                phoneNumber, email, website);
        dbUtilAdmin.updateBloodStation(bloodStation);
        showBloodStatusAndBloodStations(request, response);
    }

    private void updateBloodStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("bloodStatusID"));
        String rhdPlusA = request.getParameter("rhdPlusAInput");
        String rhdPlusB = request.getParameter("rhdPlusBInput");
        String rhdPlusAB = request.getParameter("rhdPlusABInput");
        String rhdPlus0 = request.getParameter("rhdPlus0Input");
        String rhdMinusA = request.getParameter("rhdMinusAInput");
        String rhdMinusB = request.getParameter("rhdMinusBInput");
        String rhdMinusAB = request.getParameter("rhdMinusABInput");
        String rhdMinus0 = request.getParameter("rhdMinus0Input");

        BloodStatus bloodStatus = new BloodStatus(id, rhdPlusA, rhdPlusB, rhdPlusAB, rhdPlus0, rhdMinusA, rhdMinusB,
                rhdMinusAB, rhdMinus0);
        dbUtilAdmin.updateBloodStatus(bloodStatus);
        showBloodStatusAndBloodStations(request, response);
    }

    private void loadBloodStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("bloodStationID");
        BloodStation bloodStation = dbUtilAdmin.getBloodStation(id);
        request.setAttribute("BLOOD_STATION", bloodStation);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update_blood_station_form.jsp");
        dispatcher.forward(request, response);
    }

    private void loadBloodStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BloodStatus bloodStatus = dbUtilAdmin.getStatus();
        request.setAttribute("BLOOD_STATUS", bloodStatus);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update_blood_status_form.jsp");
        dispatcher.forward(request, response);
    }

    private void addBloodStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String stationName = request.getParameter("nameInput");
        String city = request.getParameter("cityInput");
        String zipCode = request.getParameter("zipCodeInput");
        String street = request.getParameter("streetInput");
        int buildingNumber = Integer.parseInt(request.getParameter("buildingNumberInput"));
        String phoneNumber = request.getParameter("phoneNumberInput");
        String email = request.getParameter("emailInput");
        String website = request.getParameter("websiteInput");

        BloodStation bloodStation = new BloodStation(stationName, city, zipCode, street, buildingNumber, phoneNumber,
                email, website);
        dbUtilAdmin.addStation(bloodStation);
        showBloodStatusAndBloodStations(request, response);
    }

    private void listBloodStations(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<BloodStation> bloodStationList = dbUtilAdmin.getStations();
        request.setAttribute("BLOOD_STATIONS_LIST", bloodStationList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin_view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void itemBloodStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BloodStatus bloodStatus = dbUtilAdmin.getStatus();
        request.setAttribute("BLOOD_STATUS", bloodStatus);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin_view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showBloodStatusAndBloodStations(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<BloodStation> bloodStationList = dbUtilAdmin.getStations();
        BloodStatus bloodStatus = dbUtilAdmin.getStatus();
        request.setAttribute("BLOOD_STATIONS_LIST", bloodStationList);
        request.setAttribute("BLOOD_STATUS", bloodStatus);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin_view.jsp");
        requestDispatcher.forward(request, response);
    }

    private boolean validate(String username, String password) {
        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

}
