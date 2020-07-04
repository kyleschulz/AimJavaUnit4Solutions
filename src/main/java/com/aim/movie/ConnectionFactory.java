package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    /**
     * Get a connection to database
     * 
     * @return Connection object
     */
    public static Connection getConnection(String url, String user, String pass) {
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}