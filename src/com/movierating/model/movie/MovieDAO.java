package com.movierating.model.movie;

import com.movierating.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public static MovieDTO makeMovieDTO(int movieNo, String name, Date date, String genre, int runningTime, int ageLimit, String detail, int ratingCount, int accRating, String posterUrl, String nameOrigin, String nation, double average) {
        MovieDTO movie = new MovieDTO();

        movie.setMovieNo(movieNo);
        movie.setName(name);
        movie.setDate(date);
        movie.setGenre(genre);
        movie.setRunningTime(runningTime);
        movie.setAgeLimit(ageLimit);
        movie.setDetail(detail);
        movie.setRatingCount(ratingCount);
        movie.setAccRating(accRating);
        movie.setPosterUrl(posterUrl);
        movie.setNameOrigin(nameOrigin);
        movie.setNation(nation);
        movie.setAverage(average);

        return movie;
    }
    //select, update, insert, delete

    public List<MovieDTO> selectMovies() {
        ArrayList<MovieDTO> movieList = new ArrayList<>();
        String SQL = "select * from movie";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            //st.setInt(1, movieNo);
            rs = st.executeQuery();
            while (rs.next()) {
                int movieID = rs.getInt("movie_id");
                String name = rs.getString("movie_name");
                Date date = rs.getDate("movie_date");
                String genre = rs.getString("genre");
                int runningTime = rs.getInt("runningtime");
                int ageLimit = rs.getInt("age");
                String detail = rs.getString("detail");
                int ratingCount = rs.getInt("ratingcount");
                int accRating = rs.getInt("total_score");
                String posterUrl = rs.getString("poster_url");
                String nameOrigin = rs.getString("name_origin");
                String nation = rs.getString("nation");
                double average = rs.getDouble("average");

                movieList.add(makeMovieDTO(movieID, name, date, genre, runningTime, ageLimit, detail, ratingCount, accRating, posterUrl, nameOrigin, nation, average));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return movieList;
    }


    public MovieDTO selectMovieByID(int movieID) {
        MovieDTO movie = null;
        String SQL = "select * from movie";
        String SQL_WHERE_MOVIENO = " where movie_id = ?";

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL+SQL_WHERE_MOVIENO);
            st.setInt(1, movieID);
            rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString("movie_name");
                Date date = rs.getDate("movie_date");
                String genre = rs.getString("genre");
                int runningTime = rs.getInt("runningtime");
                int ageLimit = rs.getInt("age");
                String detail = rs.getString("detail");
                int ratingCount = rs.getInt("ratingcount");
                int accRating = rs.getInt("total_score");
                String posterUrl = rs.getString("poster_url");
                String nameOrigin = rs.getString("name_origin");
                String nation = rs.getString("nation");
                double average = rs.getDouble("average");

                movie = new MovieDTO(movieID, name, date, genre, runningTime, ageLimit, detail, ratingCount, accRating, posterUrl, nameOrigin, nation, average);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return movie;
    }

    public int selectMovieByCondition(String name, Date date, int runningTime) {
        String SQL = "select movie_id from movie where movie_name = ? and movie_date = ? and runningtime = ?";

        int movieNo = 0;
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setString(1, name);
            st.setDate(2, date);
            st.setInt(3, runningTime);
            rs = st.executeQuery();
            while (rs.next()) {
                movieNo = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }

        return movieNo;
    }

    public boolean insertMovie(MovieDTO movie) {
        String SQL = "insert into movie " +
                "(movie_name, movie_date, genre, runningtime, age, detail, poster_url, name_origin, nation)" +
                " values (?,?,?,?,?,?,?,?,?)";

        String name = movie.getName();
        Date date = movie.getDate();
        String genre = movie.getGenre();
        int runningTime = movie.getRunningTime();
        int ageLimit = movie.getAgeLimit();
        String detail = movie.getDetail();
        String posterUrl = movie.getPosterUrl();
        String nameOrigin = movie.getNameOrigin();
        String nation = movie.getNation();

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st1 = null;
        ResultSet rs1 = null;

        try {
            st1 = conn.prepareStatement(SQL);
            st1.setString(1, name);
            st1.setDate(2, date);
            st1.setString(3, genre);
            st1.setInt(4, runningTime);
            st1.setInt(5, ageLimit);
            st1.setString(6, detail);
            st1.setString(7, posterUrl);
            st1.setString(8, nameOrigin);
            st1.setString(9, nation);
            rs1 = st1.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.dbClose(conn, st1, rs1);
        }



        return true;
    }

    public boolean updateMovie(MovieDTO movie) {
        String SQL = "update movie set movie_name = ?, movie_date = ?, genre = ?, runningtime = ?, age = ?, detail = ?, poster_url = ?, name_origin = ?, nation = ? where movie_id = ?";

        String name = movie.getName();
        Date date = movie.getDate();
        String genre = movie.getGenre();
        int runningTime = movie.getRunningTime();
        int ageLimit = movie.getAgeLimit();
        String detail = movie.getDetail();
        String posterUrl = movie.getPosterUrl();
        String nameOrigin = movie.getNameOrigin();
        String nation = movie.getNation();
        int movie_id = movie.getMovieNo();

        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setString(1, name);
            st.setDate(2, date);
            st.setString(3, genre);
            st.setInt(4, runningTime);
            st.setInt(5, ageLimit);
            st.setString(6, detail);
            st.setString(7, posterUrl);
            st.setString(8, nameOrigin);
            st.setString(9, nation);
            st.setInt(10, movie_id);
            rs = st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.dbClose(conn, st, rs);
        }
        return true;
    }

    public boolean deleteMovie(int movieNo) {
        String SQL = "delete from movie where movie_id = ?";
        Connection conn = DBUtil.dbConnect("");
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(SQL);
            st.setInt(1, movieNo);
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
