package back;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilAdmin extends DBUtil {

    private String URL;
    private String username;
    private String password;

    public DBUtilAdmin(String URL) {
        this.URL = URL;
    }

    @Override
    public BloodStatus getStatus() throws Exception {

        BloodStatus bloodStatus = null;

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            conn = DriverManager.getConnection(URL, username, password);

            String sql = "Select * from blood_status where blood_status_id = 1";
            statement = conn.createStatement();

            resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {

                int id = resultSet.getInt("blood_status_id");
                String rhdPlusA = resultSet.getString("rhd_plus_A");
                String rhdPlusB = resultSet.getString("rhd_plus_B");
                String rhdPlusAB = resultSet.getString("rhd_plus_AB");
                String rhdPlus0 = resultSet.getString("rhd_plus_0");
                String rhdMinusA = resultSet.getString("rhd_minus_A");
                String rhdMinusB = resultSet.getString("rhd_minus_B");
                String rhdMinusAB = resultSet.getString("rhd_minus_AB");
                String rhdMinus0 = resultSet.getString("rhd_minus_0");

                bloodStatus = new BloodStatus(id, rhdPlusA, rhdPlusB, rhdPlusAB, rhdPlus0, rhdMinusA, rhdMinusB,
                        rhdMinusAB, rhdMinus0);

            }
        } finally {

            close(conn, statement, resultSet);

        }

        return bloodStatus;
    }

    @Override
    public List<BloodStation> getStations() throws Exception {

        List<BloodStation> stations = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            conn = DriverManager.getConnection(URL, username, password);

            String sql = "SELECT * FROM blood_station";
            statement = conn.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("blood_station_id");
                String name = resultSet.getString("station_name");
                String city = resultSet.getString("city");
                String zipCode = resultSet.getString("zip_code");
                String street = resultSet.getString("street");
                String buildingNumber = resultSet.getString("building_number");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String website = resultSet.getString("website");

                stations.add(new BloodStation(id, name, city, zipCode, street, Integer.parseInt(buildingNumber),
                        phoneNumber, email, website));
            }

        } finally {

            close(conn, statement, resultSet);
        }


        return stations;


    }

    public void updateBloodStatus(BloodStatus status) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(URL, username, password);
            String sql = "UPDATE blood_status SET rhd_plus_A=?, rhd_plus_B=?, rhd_plus_AB=?, rhd_plus_0=?," +
                    " rhd_minus_A=?, rhd_minus_B=?, rhd_minus_AB=?, rhd_minus_0=? WHERE blood_status_id=?";

            statement = conn.prepareStatement(sql);
            statement.setString(1, status.getRhdPlusA());
            statement.setString(2, status.getRhdPlusB());
            statement.setString(3, status.getRhdPlusAB());
            statement.setString(4, status.getRhdPlus0());
            statement.setString(5, status.getRhdMinusA());
            statement.setString(6, status.getRhdMinusB());
            statement.setString(7, status.getRhdMinusAB());
            statement.setString(8, status.getRhdMinus0());
            statement.setString(9, String.valueOf(status.getId()));

            statement.execute();
        } finally {
            close(conn, statement, null);
        }
    }

    public void addStation(BloodStation station) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(URL, username, password);

            String sql = "INSERT INTO blood_station(station_name, city, zip_code, street, building_number," +
                    " phone_number, email, website) " +
                    "VALUES(?,?,?,?,?,?,?,?)";

            statement = conn.prepareStatement(sql);
            statement.setString(1, station.getName());
            statement.setString(2, station.getCity());
            statement.setString(3, station.getZipCode());
            statement.setString(4, station.getStreet());
            statement.setString(5, Integer.toString(station.getBuildingNumber()));
            statement.setString(6, station.getPhoneNumber());
            statement.setString(7, station.getEmail());
            statement.setString(8, station.getWebsite());


            statement.execute();


        } finally {

            close(conn, statement, null);

        }

    }

    public BloodStation getBloodStation(String id) throws Exception {

        BloodStation station = null;

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            int stationID = Integer.parseInt(id);

            conn = DriverManager.getConnection(URL, username, password);

            String sql = "SELECT * FROM blood_station WHERE blood_station_id =?";

            statement = conn.prepareStatement(sql);
            statement.setInt(1, stationID);

            resultSet = statement.executeQuery();


            if (resultSet.next()) {

                String name = resultSet.getString("station_name");
                String city = resultSet.getString("city");
                String zipCode = resultSet.getString("zip_code");
                String street = resultSet.getString("street");
                String buildingNumber = resultSet.getString("building_number");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String website = resultSet.getString("website");

                station = new BloodStation(stationID, name, city, zipCode, street, Integer.parseInt(buildingNumber), phoneNumber, email, website);

            } else {
                throw new Exception("Could not find phone with id " + stationID);
            }

            return station;

        } finally {

            close(conn, statement, resultSet);

        }

    }

    public void updateBloodStation(BloodStation station) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection(URL, username, password);

            String sql = "UPDATE blood_station SET station_name=?, city=?, zip_code=?," +
                    "street=?, building_number=?, phone_number=?, email=?, website=? " +
                    "WHERE blood_station_id =?";

            statement = conn.prepareStatement(sql);
            statement.setString(1, station.getName());
            statement.setString(2, station.getCity());
            statement.setString(3, station.getZipCode());
            statement.setString(4, station.getStreet());
            statement.setString(5, Integer.toString(station.getBuildingNumber()));
            statement.setString(6, station.getPhoneNumber());
            statement.setString(7, station.getEmail());
            statement.setString(8, station.getWebsite());
            statement.setString(9, String.valueOf(station.getId()));

            statement.execute();

        } finally {

            close(conn, statement, null);

        }

    }

    public void deleteBloodStation(String id) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;
        try {

            int stationID = Integer.parseInt(id);

            conn = DriverManager.getConnection(URL, username, password);

            String sql = "DELETE FROM blood_station WHERE blood_station_id =?";

            String sqlSaveID = "ALTER TABLE blood_station AUTO_INCREMENT = ?";

            statement = conn.prepareStatement(sql);
            statement.setInt(1, stationID);

            statement.execute();

            statement = conn.prepareStatement(sqlSaveID);
            statement.setInt(1, stationID);

            statement.execute();

        } finally {

            close(conn, statement, null);

        }

    }

    public void setName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}