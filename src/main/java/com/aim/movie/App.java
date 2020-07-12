package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
//
    public static final String URL = "jdbc:postgresql://localhost:5432/movie";
    public static final String USER = "postgres";
    public static final String PASS = "bigredarmy";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Java JDBC PostgreSQL Example");
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading movie records...\n");
            System.out.format("%-35s %-5s %-30s%n", "Movie Name", "Len", "Director");
            System.out.format("%-35s %-5s %-30s%n", "----------", "---", "--------");

            ResultSet resultSet = statement.executeQuery(
                    "SELECT m.movie_name, m.movie_length, concat(d.first_name, ' ', d.last_name) full_name FROM movies m JOIN directors d on m.director_id = d.director_id;");
            while (resultSet.next()) {
                // read data from each row
                String movieName = resultSet.getString("movie_name");
                String fullName = resultSet.getString("full_name");
                int movieLength = resultSet.getInt(2);
                System.out.format("%-35s %-5d %-30s%n", movieName, movieLength, fullName);
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } finally {
            System.out.println("\nGoodbye ...");
        }
    }
}
