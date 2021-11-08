package com.movierating.model.collection;

import com.movierating.model.casting.CastingDTO;
import com.movierating.model.movie.MovieDTO;
import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CollectionDAO {
    public List<CollectionDTO> selectCollectionListByMovieNo(int movie_id) {
        ArrayList<CollectionDTO> collectionList = new ArrayList<>();
        String SQL = "select c.COLL_NO, c.NAME, c.DESCRIPTION, mem.mno, mem.MNAME, mem.mid " +
                "from COLLECTIONS c, FILM_COLLECTIONS f, movie m, members mem " +
                "where c.COLL_NO = f.COLL_NO and f.MOVIE_ID = m.MOVIE_ID and c.mno = mem.mno and f.MOVIE_ID = ?";
        CollectionDTO collection = null;

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, movie_id);
            rs = st.executeQuery();

            while (rs.next()) {
                int coll_no = rs.getInt(1);
                String coll_name = rs.getString(2);
                String coll_description = rs.getString(3);
                int mno = rs.getInt(4);

                collection = new CollectionDTO(coll_no, coll_name, coll_description, mno);
                collectionList.add(collection);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return collectionList;
    }

    public CollectionDTO makeDefaultCollection(String name, String description, int mno) {
        String SQL = "insert into COLLECTIONS (name, description, mno) values (?, ?, ?)";
        String SQL2 = "select coll_no from collections where name = ? and mno = ?";
        CollectionDTO collection = null;
        int coll_no = 0;

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setString(1, name);
            st.setString(2, description);
            st.setInt(3, mno);
            rs = st.executeQuery();

            st = conn.prepareStatement(SQL2);
            st.setString(1, name);
            st.setInt(2, mno);
            rs = st.executeQuery();
            while (rs.next()) {
                coll_no = rs.getInt(1);
            }

            if (coll_no != 0) {
                collection = new CollectionDTO(coll_no, name, description, mno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return collection;
    }

    public boolean insertMovieIntoCollection(int movie_id, int coll_no) {
        String SQL1 = "select * from film_collections where movie_id = ?";
        String SQL2 = "insert into film_collections (movie_id, coll_no) values (?, ?)";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL1);
            st.setInt(1, movie_id);
            rs = st.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                st = conn.prepareStatement(SQL2);
                st.setInt(1, movie_id);
                st.setInt(2, coll_no);
                rs = st.executeQuery();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }
    }

    public CollectionDTO selectCollection(int coll_no) {
        String SQL1 = "select * from collections where coll_no = ?";
        CollectionDTO collection = new CollectionDTO();
        collection.setColl_no(coll_no);

        String SQL2 = "select m.*, c.* " +
                "from COLLECTIONS c, FILM_COLLECTIONS f, movie m " +
                "where c.COLL_NO = f.COLL_NO and f.MOVIE_ID = m.MOVIE_ID and c.COLL_NO = ?";
        ArrayList<MovieDTO> movieList = new ArrayList<>();
        MovieDTO movie = null;
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL1);
            st.setInt(1, coll_no);
            rs = st.executeQuery();

            while (rs.next()) {
                String coll_name = rs.getString(2);
                String coll_description = rs.getString(3);
                int mno = rs.getInt(4);

                collection.setColl_name(coll_name);
                collection.setColl_description(coll_description);
                collection.setMno(mno);
            }

            st = conn.prepareStatement(SQL2);
            st.setInt(1, coll_no);
            rs = st.executeQuery();

            while(rs.next()) {
                movie = new MovieDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getDouble(13));
                movieList.add(movie);
            }

            collection.setMovieList(movieList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return collection;
    }


    public List<CollectionDTO> selectCollectionsByMno(int mno) {
        ArrayList<CollectionDTO> collectionList = new ArrayList<>();
        CollectionDTO collection = null;
        String SQL = "select * from collections where mno = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, mno);
            rs = st.executeQuery();

            while(rs.next()) {
                int coll_no = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);

                collection = new CollectionDTO(coll_no, name, description, mno);
                collectionList.add(collection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return collectionList;
    }
}
