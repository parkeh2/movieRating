package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "MovieAddServlet", value = "/movie/add")
public class MovieAddServlet extends HttpServlet {
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

        MovieService service = new MovieService();
        MovieDTO movie = new MovieDTO();

        String name = request.getParameter("name");
        String nameOrigin = request.getParameter("nameorigin");
        Date date = Date.valueOf(request.getParameter("date"));
        String genre = request.getParameter("genre");
        int runningTime = Integer.valueOf(request.getParameter("runningtime"));
        int age = Integer.valueOf(request.getParameter("age"));
        String nation = request.getParameter("nation");
        String detail = request.getParameter("detail");
        String posterUrl = request.getParameter("poster_url");

        movie.setName(name);
        movie.setNameOrigin(nameOrigin);
        movie.setDate(date);
        movie.setGenre(genre);
        movie.setRunningTime(runningTime);
        movie.setAgeLimit(age);
        movie.setNation(nation);
        movie.setDetail(detail);
        movie.setPosterUrl(posterUrl);

        boolean result = service.insertMovie(movie);

        if (result) {
            request.setAttribute("movie", movie);
            request.setAttribute("msg", "add_success");
        } else {
            request.setAttribute("msg", "add_fail");
        }

        RequestDispatcher rd = request.getRequestDispatcher("moviedetail.jsp");
        rd.forward(request, response);
    }
}
