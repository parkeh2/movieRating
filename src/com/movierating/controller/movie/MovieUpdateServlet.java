package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MovieUpdateServlet", value = "/movie/update")
public class MovieUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String movieid = request.getParameter("movieid");
        int movieNo = Integer.parseInt(movieid);
        MovieService service = new MovieService();

        MovieDTO movie = service.selectMovieByID(movieNo);
        request.setAttribute("movie", movie);

        RequestDispatcher rd = request.getRequestDispatcher("movieupdate.jsp");
        rd.forward(request, response);
    }
}
