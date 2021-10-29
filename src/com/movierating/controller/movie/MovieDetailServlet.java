package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MovieDetailServlet", value = "/movie/moviedetail")
public class MovieDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int movieNo = Integer.parseInt(request.getParameter("movieid"));
        MovieService service = new MovieService();
        MovieDTO movie = service.selectMovieByID(movieNo);
        request.setAttribute("movie", movie);
        RequestDispatcher rd = request.getRequestDispatcher("moviedetail.jsp");
        rd.forward(request, response);
    }
}
