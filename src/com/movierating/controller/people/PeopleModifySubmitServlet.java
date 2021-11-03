package com.movierating.controller.people;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;
import com.movierating.model.people.PeopleDTO;
import com.movierating.model.people.PeopleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "PeopleModifySubmitServlet", value = "/people/modify/submit")
public class PeopleModifySubmitServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String profileImageUrl = request.getParameter("profileImageUrl");

        PeopleService service = new PeopleService();
        PeopleDTO people = service.modifyPeople(pid, name, profileImageUrl);

        request.setAttribute("people", people);
        request.setAttribute("msg", "update_success");
        RequestDispatcher rd = request.getRequestDispatcher("/people/peopledetail.jsp");
        rd.forward(request, response);
    }
}
