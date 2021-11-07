package com.movierating.controller.collection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CollectionMakeServlet", value = "/collection/new")
public class CollectionMakeServlet extends HttpServlet {
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
        //int coll_no = Integer.parseInt(request.getParameter("coll_no"));

        //request.setAttribute("coll_no", coll_no);
        RequestDispatcher rd = request.getRequestDispatcher("/collection/makenewcollection.jsp");
        rd.forward(request, response);
    }
}
