package com.aim.movie;

import java.sql.Connection;
import java.util.Scanner;

import com.aim.movie.model.PostgreSQL;
import com.aim.movie.dao.Dao;
import com.aim.movie.dao.MovieDao;
import com.aim.movie.dao.MoviePostgreSqlDao;
import com.aim.movie.model.Movie;

public class MovieAppPostgreSqlJdbc {

    private static Connection connection;
    private static Dao<Movie> movieDao;

    public static void main(String[] args) {
        connection = ConnectionFactory.getConnection(PostgreSQL.URL.value, PostgreSQL.USER.value,
                PostgreSQL.PASS.value);

        movieDao = new MoviePostgreSqlDao();

        Scanner input = new Scanner(System.in);
        String movieName = input.next().toLowerCase();
        input.close();

        Movie movie = ((MovieDao) movieDao).getMovieByName(connection, movieName);

        if (movie != null) {
            System.out.println("Movie: " + movie.getMovieLength());
        } else {
            System.out.println("Movie: " + "could not find movie.");
        }

    }
}