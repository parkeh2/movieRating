package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MovieListServlet", value = "/movie/list")
public class MovieListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        MovieService service = new MovieService();
        List<MovieDTO> movies = service.selectMovies();
        request.setAttribute("movies", movies);
/*        String path = getServletContext().getRealPath("movielistall.jsp");
        System.out.println(path);*/
        RequestDispatcher rd = request.getRequestDispatcher("movielistall.jsp");
        rd.forward(request, response);
    }
}
