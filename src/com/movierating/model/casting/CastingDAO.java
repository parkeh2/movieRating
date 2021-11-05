package com.movierating.model.casting;

import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CastingDAO {
    public List<CastingDTO> selectCastingByMovieNo(int movieNo) {
        CastingDTO casting = null;
        ArrayList<CastingDTO> castingList = new ArrayList<>();
        String SQL = "select people.*, casting.role from PEOPLE, CASTING where casting.MOVIE_ID = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, movieNo);
            rs = st.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("pid");
                String name = rs.getString("movie_name");
                String profileImageUrl = rs.getString("profile_image_url");
                String role = rs.getString("role");

                casting = new CastingDTO(movieNo, pid, name, profileImageUrl, role);
                castingList.add(casting);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return castingList;
    }

}
