package com.movierating.model.rating;

public class RatingDTO {
    private int mno;
    private int movie_id;
    private int rscore;
    private String rcomment;

    public RatingDTO() {
    }

    public RatingDTO(int mno, int movie_id, int rscore, String rcomment) {
        this.mno = mno;
        this.movie_id = movie_id;
        this.rscore = rscore;
        this.rcomment = rcomment;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getRscore() {
        return rscore;
    }

    public void setRscore(int rscore) {
        this.rscore = rscore;
    }

    public String getRcomment() {
        return rcomment;
    }

    public void setRcomment(String rcomment) {
        this.rcomment = rcomment;
    }
}
