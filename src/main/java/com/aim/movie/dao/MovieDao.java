package com.aim.movie.dao;

import java.util.Set;

import com.aim.movie.model.Movie;

public interface MovieDao {

    Movie getMovie();

    Set<Movie> getAllMovies();

    Movie getMovieByMovieName();

    boolean insertMovie();

    boolean updateMovie();

    boolean deleteMovie();

}