package com.movierating.model.rating;

import com.movierating.model.people.PeopleDTO;
import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingDAO {
    public boolean insertRating(int mno, int movie_id, int rscore, String rcomment) {
        String SQL = "insert into RATING values (?, ?, ?, ?)";


        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, mno);
            st.setInt(2, movie_id);
            st.setInt(3, rscore);
            st.setString(4, rcomment);
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
