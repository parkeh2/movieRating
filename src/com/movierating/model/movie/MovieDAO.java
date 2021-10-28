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
        String SQL_WHERE_MOVIENO = " where cno = ?";

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
}
