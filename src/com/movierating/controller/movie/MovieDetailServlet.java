package com.movierating.controller.movie;

import com.movierating.model.casting.CastingDTO;
import com.movierating.model.casting.CastingService;
import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;
import com.movierating.model.rating.RatingDTO;
import com.movierating.model.rating.RatingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MovieDetailServlet", value = "/movie/moviedetail")
public class MovieDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int movieNo = Integer.parseInt(request.getParameter("movieid"));
        MovieService service = new MovieService();
        MovieDTO movie = service.selectMovieByID(movieNo);
        CastingService castingService = new CastingService();
        List<CastingDTO> castingList = castingService.selectCastingByMovieNo(movieNo);
        RatingService ratingService = new RatingService();
        List<RatingDTO> ratingList = ratingService.selectMemberRatingList(movieNo);

        request.setAttribute("movie", movie);
        request.setAttribute("castingList", castingList);
        request.setAttribute("ratingList", ratingList);
        RequestDispatcher rd = request.getRequestDispatcher("moviedetail.jsp");
        rd.forward(request, response);
    }
}
