package com.movierating.controller.casting;

import com.movierating.model.casting.CastingDTO;
import com.movierating.model.casting.CastingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CastingServlet", value = "/casting")
public class CastingServlet extends HttpServlet {
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

        CastingService service = new CastingService();
        List<CastingDTO> castingList = service.selectCastingByMovieNo(movieNo);
        //System.out.println(castingList);

        request.setAttribute("movieid", movieNo);
        request.setAttribute("castingList", castingList);

        RequestDispatcher rd = request.getRequestDispatcher("/casting/castinglist.jsp");
        rd.forward(request, response);
    }
}
