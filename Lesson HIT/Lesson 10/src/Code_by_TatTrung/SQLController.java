package demo;

import java.sql.*;

public class SQLController {

    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JavaTest";
    private final String USERNAME = "sa";
    private final String PASSWORD = "123";

    private Connection conn = null;

    public Connection CreateConnection(){
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void CloseConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet SelectAllByTable(String table){
        Connection connection = CreateConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM " + table;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
