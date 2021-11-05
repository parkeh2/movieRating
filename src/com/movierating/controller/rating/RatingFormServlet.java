package com.movierating.controller.rating;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.rating.RatingDTO;
import com.movierating.model.rating.RatingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RatingFormServlet", value = "/rating/form")
public class RatingFormServlet extends HttpServlet {
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

        String movie_id = request.getParameter("movieid");
        int movieNo = Integer.parseInt(movie_id);
        String name = request.getParameter("name");

        RatingService service = new RatingService();
        RatingDTO rating = service.selectRating(1, movieNo);

        if (rating != null) {
            System.out.println(movieNo + " / " + name + " / " + rating);
            request.setAttribute("movieid", movieNo);
            request.setAttribute("name", name);
            request.setAttribute("rating", rating);
        } else {
            System.out.println(movieNo + " / " + name);
            request.setAttribute("movieid", movieNo);
            request.setAttribute("name", name);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/rating/ratingform.jsp");
        rd.forward(request, response);
    }
}
