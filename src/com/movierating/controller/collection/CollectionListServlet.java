package com.movierating.controller.collection;

import com.movierating.model.collection.CollectionDTO;
import com.movierating.model.collection.CollectionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CollectionListServlet", value = "/collection/list")
public class CollectionListServlet extends HttpServlet {
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

        //int mno = request.getParameter("mno");
        if (request.getParameter("movieid") != null) {

        }

        CollectionService service = new CollectionService();
        List<CollectionDTO> collectionList = service.selectCollectionsByMno(1);
        request.setAttribute("collectionList", collectionList);

        RequestDispatcher rd = request.getRequestDispatcher("/collection/mycollectionlist.jsp");
        rd.forward(request, response);
    }
}
