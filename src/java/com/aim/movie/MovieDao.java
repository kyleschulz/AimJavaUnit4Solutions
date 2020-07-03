package com.aim.movie;

import java.util.Set;

public interface MovieDao {

    Movie getMovie();

    Set<Movie> getAllMovies();

    Movie getMovieByMovieName();

    boolean insertMovie();

    boolean updateMovie();

    boolean deleteMovie();

}