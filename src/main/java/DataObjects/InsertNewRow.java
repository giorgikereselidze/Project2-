package DataObjects;

import java.sql.*;

public class InsertNewRow {
    public static int insertRow(int id, String firstName, String lastName,
                                String phone, String password, String address, String email, String country, String state, String city, String zip) throws SQLException {

        ResultSet rs = null;
        int personId = 0;


        String sql = " SET IDENTITY_INSERT users ON " +
                " INSERT INTO users(id,firstName,lastName,phone,password,address,email,country,state,city,zip) " +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?) ";

        try (Connection connection = SqlDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
//            set parameters for statement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, country);
            preparedStatement.setString(9, state);
            preparedStatement.setString(10, city);
            preparedStatement.setString(11, zip);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next())
                    personId = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return personId;
    }

    public static void main(String[] args) throws SQLException {
        int id = insertRow(1000, "john", "doe", "555444333", "pass123", "address line 1", "example@gmail.com", "United States", "California", "California City", "93501");
    }

}
