package com.aim.movie;

import java.util.Date;

public class Movie {

    private Integer id;
    private String movieName;
    private int movieLength;
    private Date releaseDate;

    Movie(String movieName, int movieLength, Date releaseDate) {
        this.movieName = movieName;
        this.movieLength = movieLength;
        this.releaseDate = releaseDate;
    }

    Movie(int id, String movieName, int movieLength, Date releaseDate) {
        this.id = id;
        this.movieName = movieName;
        this.movieLength = movieLength;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}