/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbo;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Marwa
 */
public class Sql {

    private void SQLconnex() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String a = "\"";
            String connectionUrl = "jdbc:sqlserver://viper17" + a + "sql17;databaseName=GiftCard;integrateSecurity=true";
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query());
            while (rs.next()) {
                System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String query() {
        return "use GiftCard\n"
                + "select TransactionLogId as ID, GT.TransactionTypeName as TransactionType, CardNumber,Amount, Balance, Currency, StoreId, WorkstationId as Till, TransactionCode as Txn_Number, TransactionDate as SDRequestTime, ResponseDate as GiveXResponceTime, AuthCode, Void, ErrorMessage as Error\n"
                + "from GiftCardTransactionLog GL\n"
                + "join GiftCardTransactionType GT\n"
                + "on GL.TransactionType = GT.TransactionType\n"
                + "where CardNumber like '%732616%90646796%' --put the digits you have here, separated by % in front, middle and end.\n"
                + "order by TransactionLogId desc\n"
                + "rollback";
    }
}
