package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieDeleteServlet", value = "/movie/delete")
public class MovieDeleteServlet extends HttpServlet {
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

        String movieid = request.getParameter("movieid");
        int movieNo = Integer.parseInt(movieid);

        MovieService service = new MovieService();
        boolean result = service.deleteMovie(movieNo);
        if (result) {
            request.setAttribute("msg", "delete_success");
        } else {
            request.setAttribute("movieid", movieNo);
            request.setAttribute("msg", "delete_fail");
        }
        RequestDispatcher rd = request.getRequestDispatcher("moviedeleteresult.jsp");
        rd.forward(request, response);
    }
}
