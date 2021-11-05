package com.movierating.controller.search;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchMovieNameServlet", value = "/search/moviename")
public class SearchMovieNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String searchName = request.getParameter("searchname");
        MovieService service = new MovieService();
        List<MovieDTO> movies = new ArrayList<MovieDTO>();
        movies = service.selectMovieByName(searchName);

        request.setAttribute("movies", movies);
        RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
        rd.forward(request, response);
    }
}
