package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DBInitialization.init(args);
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