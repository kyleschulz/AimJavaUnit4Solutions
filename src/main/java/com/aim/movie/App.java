package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static final String URL = "jdbc:postgresql://localhost:5432/movie";
    public static final String USER = "postgres";
    public static final String PASS = "bigredarmy";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Java JDBC PostgreSQL Example");
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading car records...");
            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM movies");
            while (resultSet.next()) {
                System.out.printf("%-30.30s%n", resultSet.getString("movie_name"));
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
}
