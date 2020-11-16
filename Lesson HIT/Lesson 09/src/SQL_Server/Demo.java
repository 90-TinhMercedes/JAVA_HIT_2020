package SQL_Server;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaHIT";
        String username = "sa";
        String password = "123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM Products";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
