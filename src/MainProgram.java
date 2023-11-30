import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        Statement statement2 = null;
        ResultSet resultSetDepart = null;
        ResultSet resultSetNames = null;

        try {
            connection = DB.getConnection();

            statement = connection.createStatement();
            resultSetDepart = statement.executeQuery("select * from department");

            statement2 = connection.createStatement();
            resultSetNames = statement2.executeQuery("select * from seller");

            while (resultSetDepart.next()) {
                System.out.println(resultSetDepart.getInt("Id") + "-" +resultSetDepart.getString("name"));
            }

            System.out.println("--------------------");

            while (resultSetNames.next()) {
                System.out.println(resultSetNames.getInt("Id") + "-" +resultSetNames.getString("name") + "-" + resultSetNames.getString("email"));
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB.claseResulSet(resultSetDepart);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
