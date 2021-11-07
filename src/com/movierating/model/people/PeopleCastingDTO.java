package com.movierating.model.people;

public class PeopleCastingDTO {
    private int pid;
    private int movie_id;
    private String movie_name;
    private String movie_year;
    private String poster_url;
    private double average;
    private String role;


    public PeopleCastingDTO() {
    }


    public PeopleCastingDTO(int pid, int movie_id, String movie_name, String movie_year, String poster_url, double average, String role) {
        this.pid = pid;
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_year = movie_year;
        this.poster_url = poster_url;
        this.average = average;
        this.role = role;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(String movie_year) {
        this.movie_year = movie_year;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}