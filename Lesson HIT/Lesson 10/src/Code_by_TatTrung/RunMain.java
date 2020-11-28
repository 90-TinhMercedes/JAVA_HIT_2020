package demo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RunMain {
    public static void main(String[] args) {
        SQLController sqlController = new SQLController();
        try{
            ResultSet rs = sqlController.SelectAllByTable("HangHoa");
            while (rs.next()){
                System.out.println(rs.getInt(1) + ":" + rs.getString(2));
            }
            sqlController.CloseConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
