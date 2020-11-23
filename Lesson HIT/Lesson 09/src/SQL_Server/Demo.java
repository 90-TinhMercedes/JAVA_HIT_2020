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
            String name = "Phắc Boiz Điện Biên";
            String sqlInsert = "INSERT INTO Products VALUES(4, N'" + name + "')";

            Statement statement = connection.createStatement();
            statement.execute(sqlInsert);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
