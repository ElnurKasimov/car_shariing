package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInitialization {
    public static Connection init(String[] args) throws SQLException {
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
        return DriverManager.getConnection(url);
    }

}
