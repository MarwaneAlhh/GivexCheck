import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        SQLDatabaseConnection();
       
    }




    public static void SQLDatabaseConnection() {
        String a = "\"";
        String connectionUrl = "jdbc:sqlserver://viper17"+a+"sql17";


        try (
                Connection connection = DriverManager.getConnection(connectionUrl);) {
            System.out.println("Its working");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
