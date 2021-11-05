package com.movierating.controller.people;

import com.movierating.model.movie.MovieService;
import com.movierating.model.people.PeopleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PeopleDeleteServlet", value = "/people/delete")
public class PeopleDeleteServlet extends HttpServlet {
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
        boolean result = service.deletePeople(pid);
        if (result) {
            request.setAttribute("msg", "delete_success");
        } else {
            request.setAttribute("pid", pid);
            request.setAttribute("msg", "delete_fail");
        }
        RequestDispatcher rd = request.getRequestDispatcher("peopledelete.jsp");
        rd.forward(request, response);
    }
}
