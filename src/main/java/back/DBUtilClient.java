package back;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtilClient extends DBUtil {

    private DataSource dataSource;

    public DBUtilClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<BloodStation> getStations() throws Exception {

        List<BloodStation> stations = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            conn = dataSource.getConnection();

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

    @Override
    public BloodStatus getStatus() throws Exception {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        BloodStatus bloodStatus = null;

        try{
            conn = dataSource.getConnection();
            String sql = "Select * FROM blood_status where blood_status_id = 1";
            statement = conn.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

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
}
