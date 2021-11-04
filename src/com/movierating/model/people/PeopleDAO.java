package com.movierating.model.people;

import com.movierating.model.movie.MovieDTO;
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

    public PeopleDTO addPeople(String name, String profileImageUrl) {
        PeopleDTO people = null;
        String SQL = "insert into PEOPLE (name, PROFILE_IMAGE_URL) values (?, ?)";
        String SQL_getPid = "select pid from PEOPLE where name = ? and PROFILE_IMAGE_URL = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;
        int pid = 0;

        try {
            st = conn.prepareStatement(SQL);
            st.setString(1, name);
            st.setString(2, profileImageUrl);
            rs = st.executeQuery();

            st = conn.prepareStatement(SQL_getPid);
            st.setString(1, name);
            st.setString(2, profileImageUrl);
            rs = st.executeQuery();
            while(rs.next()) {
                pid = rs.getInt(1);
            }
            people = new PeopleDTO(pid, name, profileImageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return people;
    }

    public PeopleDTO modifyPeople(int pid, String name, String profileImageUrl) {
        PeopleDTO people = null;
        String SQL = "update people set name = ?, profile_image_url = ? where pid = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setString(1, name);
            st.setString(2, profileImageUrl);
            st.setInt(3, pid);
            rs = st.executeQuery();

            people = new PeopleDTO(pid, name, profileImageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return people;
    }

    public boolean deletePeople(int pid) {
        String SQL = "delete from PEOPLE where pid = ?";
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, pid);
            rs = st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }
        return true;
    }

    public List<PeopleDTO> selectPeopleByName(String searchName) {
        PeopleDTO people = null;
        ArrayList<PeopleDTO> peopleList = new ArrayList<>();
        String SQL = "select * from PEOPLE where NAME like \'%"+ searchName +"%\'";
        System.out.println(SQL);

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("pid");
                String name = rs.getString("name");
                String profileImageUrl = rs.getString("profile_image_url");

                people = new PeopleDTO(pid, name, profileImageUrl);
                peopleList.add(people);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return peopleList;
    }
}
