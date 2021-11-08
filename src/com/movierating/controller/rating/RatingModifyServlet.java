package com.movierating.controller.rating;

import com.movierating.model.rating.RatingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RatingModifyServlet", value = "/rating/modify")
public class RatingModifyServlet extends HttpServlet {
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

        String movie_id_Str = request.getParameter("movieid");
        int movie_id = Integer.parseInt(movie_id_Str);
        System.out.println(movie_id);
        String rscore_Str = request.getParameter("rscore");
        int rscore = Integer.parseInt(rscore_Str);
        String rcomment = request.getParameter("rcomment");

        RatingService service = new RatingService();
        boolean result = service.updateRating(1, movie_id, rscore, rcomment);

        if (result) {
            request.setAttribute("msg", "insert_success");
            request.setAttribute("mno", 1);
            request.setAttribute("movieid", movie_id);
            request.setAttribute("rscore", rscore);
            request.setAttribute("rcomment", rcomment);
        } else {
            request.setAttribute("msg", "insert_fail");
            request.setAttribute("mno", 1);
            request.setAttribute("movieid", movie_id);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/rating/ratingresult.jsp");
        rd.forward(request, response);
    }
}
