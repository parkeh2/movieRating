package com.movierating.model.collection;

import com.movierating.model.movie.MovieDTO;

import java.util.ArrayList;

public class CollectionDTO {
    private int coll_no;
    private String coll_name;
    private String coll_description;
    private int mno;
    private ArrayList<MovieDTO> movieList;

    public CollectionDTO() {
    }

    public CollectionDTO(int coll_no, String coll_name, String coll_description, int mno) {
        this.coll_no = coll_no;
        this.coll_name = coll_name;
        this.coll_description = coll_description;
        this.mno = mno;
    }

    public CollectionDTO(int coll_no, String coll_name, String coll_description, int mno, ArrayList<MovieDTO> movieList) {
        this.coll_no = coll_no;
        this.coll_name = coll_name;
        this.coll_description = coll_description;
        this.mno = mno;
        this.movieList = movieList;
    }

    public int getColl_no() {
        return coll_no;
    }

    public void setColl_no(int coll_no) {
        this.coll_no = coll_no;
    }

    public String getColl_name() {
        return coll_name;
    }

    public void setColl_name(String coll_name) {
        this.coll_name = coll_name;
    }

    public String getColl_description() {
        return coll_description;
    }

    public void setColl_description(String coll_description) {
        this.coll_description = coll_description;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public ArrayList<MovieDTO> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<MovieDTO> movieList) {
        this.movieList = movieList;
    }
}
