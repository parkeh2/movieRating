package com.movierating.controller.people;

import com.movierating.model.people.PeopleDTO;
import com.movierating.model.people.PeopleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PeopleModifyServlet", value = "/people/modify")
public class PeopleModifyServlet extends HttpServlet {
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

        String pidStr = request.getParameter("pid");
        int pid = Integer.parseInt(pidStr);
        PeopleService service = new PeopleService();
        PeopleDTO people = service.selectPeople(pid);

        request.setAttribute("people", people);
        RequestDispatcher rd = request.getRequestDispatcher("peoplemodify.jsp");
        rd.forward(request, response);
    }


}
