package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "MovieInsertServlet", value = "/movie/insert")
public class MovieInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String nameOrigin = request.getParameter("nameorigin");
        Date date = Date.valueOf(request.getParameter("date"));
        String genre = request.getParameter("genre");
        int runningTime = Integer.valueOf(request.getParameter("runningtime"));
        int age = Integer.valueOf(request.getParameter("age"));
        String nation = request.getParameter("nation");
        String detail = request.getParameter("detail");
        String posterUrl = request.getParameter("poster_url");

        MovieDTO movie = new MovieDTO();

        movie.setName(name);
        movie.setNameOrigin(nameOrigin);
        movie.setDate(date);
        movie.setGenre(genre);
        movie.setRunningTime(runningTime);
        movie.setAgeLimit(age);
        movie.setNation(nation);
        movie.setDetail(detail);
        movie.setPosterUrl(posterUrl);

        MovieService service = new MovieService();
        boolean result = service.insertMovie(movie);

        List<MovieDTO> movies = service.selectMovies();
        request.setAttribute("movies", movies);

        RequestDispatcher rd = request.getRequestDispatcher("movielistall.jsp");
        rd.forward(request, response);
    }
}
