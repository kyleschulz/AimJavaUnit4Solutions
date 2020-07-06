package com.aim.movie;

import java.sql.Connection;
import java.util.Scanner;

import com.aim.movie.util.MySQL;

import org.apache.commons.lang3.StringUtils;

import com.aim.movie.util.ConnectionFactory;
import com.aim.movie.dao.Dao;
import com.aim.movie.dao.MovieDao;
import com.aim.movie.dao.MovieMySqlDao;
import com.aim.movie.model.Movie;

public class MovieAppMySqlJdbc {

    private static Connection connection;
    private static Dao<Movie> movieDao;

    public static void main(String[] args) {
        connection = ConnectionFactory.getConnection(MySQL.URL.value, MySQL.USER.value, MySQL.PASS.value);

        movieDao = new MovieMySqlDao();

        Scanner input = new Scanner(System.in);
        String movieName = input.next().toLowerCase();
        input.close();

        Movie movie = ((MovieDao) movieDao).getMovieByName(connection, movieName);

        if (movie != null) {
            System.out.println("Movie: " + StringUtils.abbreviate(movie.getMovieName(), 4));
        } else {
            System.out.println("Movie: " + "could not find movie.");
        }

    }
}