package com.movierating.model.rating;

public class RatingService {
    RatingDAO dao = new RatingDAO();

    public boolean insertRating(int mno, int movie_id, int rscore, String rcomment) {
        return dao.insertRating(mno, movie_id, rscore, rcomment);
    }
}
