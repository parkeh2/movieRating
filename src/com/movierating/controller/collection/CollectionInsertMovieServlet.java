package com.movierating.controller.collection;

import com.movierating.model.collection.CollectionDTO;
import com.movierating.model.collection.CollectionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CollectionInsertMovieServlet", value = "/collection/addmovie")
public class CollectionInsertMovieServlet extends HttpServlet {
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

        String movie_id_str = request.getParameter("movieid");
        int movie_id = Integer.parseInt(movie_id_str);
        String name = request.getParameter("moviename");
        CollectionService service = new CollectionService();
        List<CollectionDTO> collectionList = service.selectCollectionsByMno(1);
        request.setAttribute("movie_id", movie_id);
        request.setAttribute("movie_name", name);
        request.setAttribute("collectionList", collectionList);

        RequestDispatcher rd = request.getRequestDispatcher("/collection/addmovie.jsp");
        rd.forward(request, response);
    }
}
