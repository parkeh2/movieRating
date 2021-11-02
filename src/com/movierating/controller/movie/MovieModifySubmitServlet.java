package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "MovieModifySubmitServlet", value = "/movie/modify/submit")
public class MovieModifySubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if (result) {
            request.setAttribute("movie", movie);
            request.setAttribute("msg", "update_success");
        } else {
            request.setAttribute("msg", "update_fail");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/movie/moviedetail.jsp");
        rd.forward(request, response);
    }
}
