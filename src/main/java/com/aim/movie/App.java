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
            System.out.println("Reading movie records...\n");
            System.out.format("%-30.30s  %-30.30s%n", "Movie Name", "Director");
            System.out.format("%-30.30s  %-30.30s%n", "----------", "--------");

            ResultSet resultSet = statement.executeQuery(
                    "SELECT m.movie_name, concat(d.first_name, ' ', d.last_name) full_name FROM movies m JOIN directors d on m.director_id = d.director_id;");
            while (resultSet.next()) {
                System.out.format("%-30.30s  %-30.30s%n", resultSet.getString("movie_name"),
                        resultSet.getString("full_name"));
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
        } finally {
            System.out.println("\nGoodbye ...");
        }
    }
}
