package com.aim.movie;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

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
            DriverManager.registerDriver(new Driver() {

                @Override
                public boolean jdbcCompliant() {
                    // TODO Auto-generated method stub
                    return false;
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public int getMinorVersion() {
                    // TODO Auto-generated method stub
                    return 0;
                }

                @Override
                public int getMajorVersion() {
                    // TODO Auto-generated method stub
                    return 0;
                }

                @Override
                public Connection connect(String url, Properties info) throws SQLException {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public boolean acceptsURL(String url) throws SQLException {
                    // TODO Auto-generated method stub
                    return false;
                }
            });
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}