package SQL;

import java.sql.*;

public class Demo {
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaHIT";
    private static final String username = "sa";
    private static final String password = "123";
    public static void main(String[] args) {


        try {
            Connection connection = DriverManager.getConnection(url, username, password);

//            int STT = 6;
//            String name = "Con Đĩ Điện Biên";
//            String sqlInsert = "INSERT INTO Products VALUES(?,?)";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
//            preparedStatement.setInt(1, STT);
//            preparedStatement.setString(2, name);
//            preparedStatement.execute();

//            connection.close();
            String sql = "SELECT * FROM Products";
            Statement statement = connection.createStatement();
            statement.execute(sql);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString(2));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
