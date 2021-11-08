package com.movierating.controller.collection;

import com.movierating.model.collection.CollectionDTO;
import com.movierating.model.collection.CollectionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CollectionDetailServlet", value = "/collection/detail")
public class CollectionDetailServlet extends HttpServlet {
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

        int coll_no = Integer.parseInt(request.getParameter("coll_no"));
        CollectionService service = new CollectionService();
        CollectionDTO collection = service.selectCollection(coll_no);

        request.setAttribute("collection", collection);
        RequestDispatcher rd = request.getRequestDispatcher("/collection/collectiondetail.jsp");
        rd.forward(request, response);
    }
}
