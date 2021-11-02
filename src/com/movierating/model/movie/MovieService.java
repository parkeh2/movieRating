package com.movierating.model.movie;

import java.sql.Date;
import java.util.List;

public class MovieService {
    MovieDAO dao = new MovieDAO();

    public List<MovieDTO> selectMovies() {
        return dao.selectMovies();
    }

    public MovieDTO selectMovieByID(int movieNo) {
        return dao.selectMovieByID(movieNo);
    }

    public boolean insertMovie(MovieDTO movie) {
        return dao.insertMovie(movie);
    }

    public boolean updateMovie(MovieDTO movie) {
        return dao.updateMovie(movie);
    }

    public boolean deleteMovie(int movieNo) {
        return dao.deleteMovie(movieNo);
    }

    public int selectMovieByCondition(String name, Date date, int runningTime) {
        return dao.selectMovieByCondition(name, date, runningTime);
    }
}
