package com.movierating.model.movie;

import java.util.List;

public class MovieService {
    MovieDAO dao = new MovieDAO();

    public List<MovieDTO> selectMovies() {
        return dao.selectMovies();
    }

    public MovieDTO selectMovieByID(int movieNo) {
        return dao.selectMovieByID(movieNo);
    }
}
