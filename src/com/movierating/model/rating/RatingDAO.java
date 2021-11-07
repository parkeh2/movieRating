package com.movierating.model.rating;

import com.movierating.model.people.PeopleDTO;
import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public boolean updateRating(int mno, int movie_id, int rscore, String rcomment) {
        String SQL1 = "update rating set RSCORE = ?, RCOMMENT = ? where mno = ? and movie_id = ?";
        String SQL3 = "update movie set average = total_score/ratingcount where movie_id = ?";
        String SQL4 = "commit";
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL1);
            st.setInt(1, rscore);
            st.setString(2, rcomment);
            st.setInt(3, mno);
            st.setInt(4, movie_id);
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

    public RatingDTO selectRating(int mno, int movieNo) {
        String SQL1 = "select * from RATING where MNO = ? and MOVIE_ID = ?";
        RatingDTO rating = null;
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL1);
            st.setInt(1, mno);
            st.setInt(2, movieNo);
            rs = st.executeQuery();
            while (rs.next()) {
                rating = new RatingDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return rating;
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }
        return rating;
    }

    public List<RatingDTO> selectMemberRatingList(int movie_id) {
        ArrayList<RatingDTO> ratingList = new ArrayList<>();
        RatingDTO rating = null;
        String SQL = "select m.mno, m.mname, m.mid, r.MOVIE_ID, r.RSCORE, r.RCOMMENT " +
                "from MEMBERS m, RATING r " +
                "where m.mno = r.mno and r.movie_id = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, movie_id);
            rs = st.executeQuery();
            while (rs.next()) {
                rating = new RatingDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                ratingList.add(rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }
        return ratingList;
    }
}
