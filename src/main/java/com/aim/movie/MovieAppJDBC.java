package com.aim.movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aim.movie.model.Movie;

public class MovieAppJDBC {

    private static Connection connection;

    public static Movie getMovie(Connection connection, String movieName) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies WHERE lower(movie_name) = '" + movieName + "';");
            if (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getInt("movie_id"));
                movie.setDirectorId(rs.getInt("director_id"));
                movie.setMovieName(rs.getString("movie_name"));
                movie.setMovieLength(rs.getInt("movie_length"));
                movie.setReleaseDate(rs.getDate("release_date"));
                return movie;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        connection = ConnectionFactory.getConnection();

        Scanner input = new Scanner(System.in);
        String movieName = input.next().toLowerCase();
        input.close();

        Movie movie = getMovie(connection, movieName);
        if (movie != null) {
            System.out.println("Movie: " + movie.getMovieLength());
        } else {
            System.out.println("Movie: " + "could not find movie.");
        }

    }
}