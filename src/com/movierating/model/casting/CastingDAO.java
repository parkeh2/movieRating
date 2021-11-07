package com.movierating.model.casting;

import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CastingDAO {
    public List<CastingDTO> selectCastingByMovieNo(int movieNo) {
        ArrayList<CastingDTO> castingList = new ArrayList<>();
        String SQL = "select p.pid, p.name, p.PROFILE_IMAGE_URL, c.role from PEOPLE p, CASTING c where p.pid = c.pid and c.MOVIE_ID = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, movieNo);
            rs = st.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                String profileImageUrl = rs.getString(3);
                String role = rs.getString(4);

                CastingDTO casting = new CastingDTO(movieNo, pid, name, profileImageUrl, role);
                System.out.println(casting);
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
