package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
       SQLDatabaseConnection();

    }

    public static void SQLDatabaseConnection() {
        String a = "\"";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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