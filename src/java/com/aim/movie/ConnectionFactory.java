package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionFactory {

    public static final String URL = "jdbc:postgresql://localhost:5432/movie";
    public static final String USER = "postgres";
    public static final String PASS = "bigredarmy";

    /**
     * Get a connection to database
     * 
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}