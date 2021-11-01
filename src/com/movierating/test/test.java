package com.movierating.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/test/test")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        System.out.println("doget 테스트");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        System.out.println("name : " + name);
        System.out.println("phone : " + phone);

/*        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("phone", phone);*/

        RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
        rd.forward(request, response);

    }

}
