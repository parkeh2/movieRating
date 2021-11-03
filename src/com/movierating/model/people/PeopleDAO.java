package com.movierating.model.people;

import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PeopleDAO {
    public List<PeopleDTO> selectPeoples() {
        ArrayList<PeopleDTO> peopleList = new ArrayList<>();
        String SQL = "select * from people";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                String profileImageUrl = rs.getString(3);

                peopleList.add(new PeopleDTO(pid, name, profileImageUrl));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return peopleList;
    }

    public PeopleDTO selectPeople(int pid) {
        PeopleDTO people = null;
        String SQL = "select name, PROFILE_IMAGE_URL from people where pid = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, pid);
            rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String profileImageUrl = rs.getString(2);

                people = new PeopleDTO(pid, name, profileImageUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return people;
    }
}
