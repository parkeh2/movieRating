package com.movierating.controller.people;

import com.movierating.model.people.PeopleCastingDTO;
import com.movierating.model.people.PeopleDTO;
import com.movierating.model.people.PeopleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeopleDetailServlet", value = "/people/detail")
public class PeopleDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String pidStr = request.getParameter("pid");
        int pid = Integer.parseInt(pidStr);

        PeopleService service = new PeopleService();
        PeopleDTO people = service.selectPeople(pid);
        List<PeopleCastingDTO> castingList = service.selectPeopleCasting(pid);

        request.setAttribute("people", people);
        request.setAttribute("castingList", castingList);
        RequestDispatcher rd = request.getRequestDispatcher("peopledetail.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }
}
