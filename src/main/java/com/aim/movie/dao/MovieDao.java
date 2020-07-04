package com.aim.movie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.aim.movie.model.Movie;

public class MovieDao implements Dao<Movie> {

    public Movie getMovieByName(Connection connection, String movieName) {
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

    @Override
    public Optional<Movie> get(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movie> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Movie t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Movie t, String[] params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Movie t) {
        // TODO Auto-generated method stub

    }

}