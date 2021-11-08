package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieListServlet", value = "/movie/list")
public class MovieListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        MovieService service = new MovieService();
        List<MovieDTO> movies = service.selectMovies();


        request.setAttribute("movies", movies);
        RequestDispatcher rd = request.getRequestDispatcher("movielistall.jsp");
        rd.forward(request, response);
    }
}
