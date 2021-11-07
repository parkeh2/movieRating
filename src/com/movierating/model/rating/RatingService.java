package com.movierating.model.rating;

import java.util.List;

public class RatingService {
    RatingDAO dao = new RatingDAO();

    public boolean insertRating(int mno, int movie_id, int rscore, String rcomment) {
        return dao.insertRating(mno, movie_id, rscore, rcomment);
    }

    public RatingDTO selectRating(int mno, int movieNo) {
        return dao.selectRating(mno, movieNo);
    }

    public List<RatingDTO> selectMemberRatingList(int movie_id){
        return dao.selectMemberRatingList(movie_id);
    }

    public boolean updateRating(int mno, int movie_id, int rscore, String rcomment) {
        return dao.updateRating(mno, movie_id, rscore, rcomment);
    }
}
