package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String dbName = "";
        if ("-databaseFileName".equals(args[0]) && "carsharing".equals(args[1])) {
            dbName = args[1];
        } else {
            dbName = "someDatabase";
        }

        String url = "jdbc:h2:./src/carsharing/db/" + dbName;
        try {
            Class.forName ("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection con = DriverManager.getConnection(url);
             Statement stat = con.createStatement() ){
            con.setAutoCommit(true);
            String createCompanyTable = "CREATE TABLE IF NOT EXISTS COMPANY (" +
                    "ID INT," +
                    "NAME VARCHAR(50));";
            int res = stat.executeUpdate(createCompanyTable);
            System.out.println(res);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}