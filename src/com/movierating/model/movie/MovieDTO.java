package com.movierating.model.movie;

import java.sql.Date;

public class MovieDTO {
    private int movieNo;
    private String name;
    private Date date;
    private String genre;
    private int runningTime;
    private int ageLimit;
    private String detail;
    private int ratingCount;
    private int accRating;
    private String posterUrl;
    private String nameOrigin;
    private String nation;
    private double average;

    public MovieDTO() {
    }

    public MovieDTO(int movieNo, String name, Date date, String genre, int runningTime, int ageLimit, String detail, int ratingCount, int accRating, String posterUrl, String nameOrigin, String nation, double average) {
        this.movieNo = movieNo;
        this.name = name;
        this.date = date;
        this.genre = genre;
        this.runningTime = runningTime;
        this.ageLimit = ageLimit;
        this.detail = detail;
        this.ratingCount = ratingCount;
        this.accRating = accRating;
        this.posterUrl = posterUrl;
        this.nameOrigin = nameOrigin;
        this.nation = nation;
        this.average = average;
    }

    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public int getAccRating() {
        return accRating;
    }

    public void setAccRating(int accRating) {
        this.accRating = accRating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getNameOrigin() {
        return nameOrigin;
    }

    public void setNameOrigin(String nameOrigin) {
        this.nameOrigin = nameOrigin;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
