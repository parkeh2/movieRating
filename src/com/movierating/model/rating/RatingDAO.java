package com.movierating.model.rating;

import com.movierating.model.people.PeopleDTO;
import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingDAO {
    public boolean insertRating(int mno, int movie_id, int rscore, String rcomment) {
        String SQL1 = "insert into RATING values (?, ?, ?, ?)";
        String SQL2 = "update movie set ratingcount = ratingcount + 1, total_score = total_score + ? where movie_id = ?";
        String SQL3 = "update movie set average = total_score/ratingcount where movie_id = ?";
        String SQL4 = "commit";
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL1);
            st.setInt(1, mno);
            st.setInt(2, movie_id);
            st.setInt(3, rscore);
            st.setString(4, rcomment);
            rs = st.executeQuery();

            st = conn.prepareStatement(SQL2);
            st.setInt(1, rscore);
            st.setInt(2, movie_id);
            rs = st.executeQuery();

            st = conn.prepareStatement(SQL3);
            st.setInt(1, movie_id);
            rs = st.executeQuery();

            st = conn.prepareStatement(SQL4);
            rs = st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return true;
    }
}
