package com.movierating.model.rating;

public class RatingDTO {
    private int mno;
    private String mname;
    private String mid;
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

    public RatingDTO(int mno, String mname, String mid, int movie_id, int rscore, String rcomment) {
        this.mno = mno;
        this.mname = mname;
        this.mid = mid;
        this.movie_id = movie_id;
        this.rscore = rscore;
        this.rcomment = rcomment;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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
