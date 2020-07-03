package com.aim.movie;

import java.util.Date;

public class Movie {

    private int movieId;
    private int directorId;
    private String movieName;
    private int movieLength;
    private Date releaseDate;

    Movie() {

    }

    Movie(String movieName, int movieLength, Date releaseDate) {
        this.movieName = movieName;
        this.movieLength = movieLength;
        this.releaseDate = releaseDate;
    }

    Movie(int movieId, int directorId, String movieName, int movieLength, Date releaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieLength = movieLength;
        this.releaseDate = releaseDate;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getMovieId() {
        return movieId;
    }

}