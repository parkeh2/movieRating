package com.movierating.controller.people;

import com.movierating.model.people.PeopleDTO;
import com.movierating.model.people.PeopleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeopleListServlet", value = "/people/list")
public class PeopleListServlet extends HttpServlet {
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

        PeopleService service = new PeopleService();
        List<PeopleDTO> peopleList = service.selectPeoples();

        request.setAttribute("peopleList", peopleList);
        RequestDispatcher rd = request.getRequestDispatcher("peoplelist.jsp");
        rd.forward(request, response);
    }
}
