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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setCharacterEncoding("utf-8");

        String movieid = request.getParameter("movieid");
        int movieNo = Integer.parseInt(movieid);

/*        String name = request.getParameter("name");
        String nameOrigin = request.getParameter("nameorigin");
        Date date = Date.valueOf(request.getParameter("date"));
        String genre = request.getParameter("genre");
        int runningTime = Integer.valueOf(request.getParameter("runningtime"));
        int age = Integer.valueOf(request.getParameter("age"));
        String nation = request.getParameter("nation");
        String detail = request.getParameter("detail");
        String posterUrl = request.getParameter("poster_url");*/

        MovieService service = new MovieService();
        MovieDTO movie = service.selectMovieByID(movieNo);

        request.setAttribute("movie", movie);
        RequestDispatcher rd = request.getRequestDispatcher("moviemodify.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }
}
