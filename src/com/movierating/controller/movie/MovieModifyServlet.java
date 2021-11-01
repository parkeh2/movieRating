package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "MovieModifyServlet", value = "/movie/modify")
public class MovieModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String movieid = request.getParameter("movieid");
        int movieNo = Integer.parseInt(movieid);
        String name = request.getParameter("name");
        String nameOrigin = request.getParameter("nameorigin");
        Date date = Date.valueOf(request.getParameter("date"));
        String genre = request.getParameter("genre");
        int runningTime = Integer.valueOf(request.getParameter("runningtime"));
        int age = Integer.valueOf(request.getParameter("age"));
        String nation = request.getParameter("nation");
        String detail = request.getParameter("detail");
        String posterUrl = request.getParameter("poster_url");


        MovieService service = new MovieService();
        MovieDTO movie = service.selectMovieByID(movieNo);
        MovieDTO newMovie = new MovieDTO();
        newMovie.setName(name);
        newMovie.setNameOrigin(nameOrigin);
        newMovie.setDate(date);
        newMovie.setGenre(genre);
        newMovie.setRunningTime(runningTime);
        newMovie.setAgeLimit(age);
        newMovie.setNation(nation);
        newMovie.setDetail(detail);
        newMovie.setPosterUrl(posterUrl);


        // 변경된 항목 찾기


        movie.setName(name);
        movie.setNameOrigin(nameOrigin);
        movie.setDate(date);
        movie.setGenre(genre);
        movie.setRunningTime(runningTime);
        movie.setAgeLimit(age);
        movie.setNation(nation);
        movie.setDetail(detail);
        movie.setPosterUrl(posterUrl);

        boolean result = service.updateMovie(movie);
        String nextPage;
        if (result) {
            request.setAttribute("movie", movie);
            nextPage = "moviedetail?movieid=" + movieNo + ".jsp";
        } else {
            nextPage = "moviemodifyresult.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);

    }
}
