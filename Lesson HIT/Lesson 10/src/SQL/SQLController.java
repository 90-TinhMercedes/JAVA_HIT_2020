package SQL;

import javax.security.auth.login.CredentialException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLController {
    private final String URF = "jdbc:sqlserver://localhost:1433;databaseName=JavaHIT";
    private final String username = "sa";
    private final String password = "123";
    private Connection conn = null;
    public Connection GetConnection() {

        try {
            conn = DriverManager.getConnection(URF, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public void CloseCOnnection(){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet SelectAllByTable(String table){
        Connection connection = GetConnection();
        ResultSet rs = null;
        String url;



        return rs;
    }


}
