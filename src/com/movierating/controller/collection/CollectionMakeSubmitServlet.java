package com.movierating.controller.collection;

import com.movierating.model.collection.CollectionDTO;
import com.movierating.model.collection.CollectionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CollectionMakeNewServlet", value = "/collection/new/submit")
public class CollectionMakeSubmitServlet extends HttpServlet {
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

        String coll_name = request.getParameter("coll_name");
        String coll_description = request.getParameter("coll_description");
        int mno = 1;

        CollectionService service = new CollectionService();
        CollectionDTO collection = service.makeDefaultCollection(coll_name, coll_description, mno);

        request.setAttribute("collection", collection);

        RequestDispatcher rd = request.getRequestDispatcher("/collection/makenewcollectionresult.jsp");
        rd.forward(request, response);
    }
}
