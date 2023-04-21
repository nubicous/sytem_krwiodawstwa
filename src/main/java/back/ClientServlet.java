package back;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

    private DataSource dataSource;
    private DBUtilClient dbUtilClient;

    public ClientServlet() {
        Context initCtx = null;
        try{
            initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/blood_stations");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init() throws ServletException {
        super.init();

        try{

            dbUtilClient = new DBUtilClient(dataSource);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listStationsAndStatus(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listStationsAndStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<BloodStation>  bloodStationList = dbUtilClient.getStations();
        BloodStatus bloodStatus = dbUtilClient.getStatus();

        String filter = request.getParameter("filter");
        String search = request.getParameter("search");
        if (filter != null && search != null) {
            List<BloodStation> filteredList = bloodStationList.stream().filter(p -> {
                if (filter.equals("name")) {
                    return p.getName().contains(search);
                } else if (filter.equals("city")) {
                    return p.getCity().contains(search);
                } else {
                    return false;
                }
            }).toList();
            request.setAttribute("BLOOD_STATIONS", filteredList);
        } else {
            request.setAttribute("BLOOD_STATIONS", bloodStationList);
        }
        request.setAttribute("BLOOD_STATUS", bloodStatus);

        RequestDispatcher dispatcher = request.getRequestDispatcher("client_view.jsp");
        dispatcher.forward(request, response);
    }

}
