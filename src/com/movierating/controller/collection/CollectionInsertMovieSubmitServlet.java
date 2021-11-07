package com.movierating.controller.collection;

import com.movierating.model.collection.CollectionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CollectionInsertMovieResultServlet", value = "/collection/addmovie/submit")
public class CollectionInsertMovieSubmitServlet extends HttpServlet {
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

        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
        int coll_no = Integer.parseInt(request.getParameter("coll_no"));

        CollectionService service = new CollectionService();
        boolean result = service.insertMovieIntoCollection(movie_id, coll_no);

        if (result) {
            request.setAttribute("msg", "insert_success");
            request.setAttribute("coll_no", coll_no);
        } else {
            request.setAttribute("msg", "insert_fail");
        }
        request.setAttribute("movieid", movie_id);

        RequestDispatcher rd = request.getRequestDispatcher("/collection/addmovieresult.jsp");
        rd.forward(request, response);
    }
}
