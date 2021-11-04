package com.movierating.controller.search;

import com.movierating.model.people.PeopleDTO;
import com.movierating.model.people.PeopleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchPeopleServlet", value = "/search/people")
public class SearchPeopleServlet extends HttpServlet {
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

        String searchName = request.getParameter("searchname");
        PeopleService service = new PeopleService();
        List<PeopleDTO> peopleList = new ArrayList<PeopleDTO>();
        peopleList = service.selectPeopleByName(searchName);

        request.setAttribute("people", peopleList);
        RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
        rd.forward(request, response);
    }
}
