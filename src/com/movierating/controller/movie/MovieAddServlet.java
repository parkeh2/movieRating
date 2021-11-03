package com.movierating.controller.movie;

import com.movierating.model.movie.MovieDTO;
import com.movierating.model.movie.MovieService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "MovieAddServlet", value = "/movie/add")
public class MovieAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = "utf-8";
        request.setCharacterEncoding(encoding);
        MovieService service = new MovieService();
        MovieDTO movie = new MovieDTO();
/*

        String name, nameOrigin, genre, nation, detail, posterUrl;
        Date date;
        int runningTime, age;
*/


/*
        String name = request.getParameter("name");
        String nameOrigin = request.getParameter("nameorigin");
        Date date = Date.valueOf(request.getParameter("date"));
        String genre = request.getParameter("genre");
        int runningTime = Integer.valueOf(request.getParameter("runningtime"));
        int age = Integer.valueOf(request.getParameter("age"));
        String nation = request.getParameter("nation");
        String detail = request.getParameter("detail");
        String posterUrl = request.getParameter("poster_url");
*/

        String name = null;
        String nameOrigin = null;
        Date date = null;
        String genre = null;
        int runningTime = 0;
        int age = 0;
        String nation = null;
        String detail = null;
        String posterUrl = null;


        // 파일 업로드 구현중
        String path = getServletContext().getRealPath("/images/poster");
        File currentDirPath = new File(path);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(currentDirPath);
        factory.setSizeThreshold(1024 * 1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List items = upload.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);

                if (fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    if (fieldName.equals("name")) {
                        name = fileItem.getString(encoding);
                    } else if (fieldName.equals("nameorigin")) {
                        nameOrigin = fileItem.getString(encoding);
                    } else if (fieldName.equals("date")) {
                        String dateString = fileItem.getString(encoding);
                        System.out.println(dateString);
                        date = java.sql.Date.valueOf(dateString);
                    } else if (fieldName.equals("genre")) {
                        genre = fileItem.getString(encoding);
                    } else if (fieldName.equals("runningtime")) {
                        runningTime = Integer.parseInt(fileItem.getString(encoding));
                    } else if (fieldName.equals("age")) {
                        age = Integer.parseInt(fileItem.getString(encoding));
                    } else if (fieldName.equals("nation")) {
                        nation = fileItem.getString(encoding);
                    } else if (fieldName.equals("detail")) {
                        detail = fileItem.getString(encoding);
                    }
                    System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
                } else {
                    System.out.println("파라미터명:" + fileItem.getFieldName());
                    System.out.println("파일명:" + fileItem.getName());
                    System.out.println("파일크기:" + fileItem.getSize() + "bytes");

                    if (fileItem.getSize() > 0) {
                        int idx = fileItem.getName().lastIndexOf("\\");
                        if (idx == -1) {
                            idx = fileItem.getName().lastIndexOf("/");
                        }
                        String fileName = fileItem.getName().substring(idx + 1);
                        File uploadFile = new File(currentDirPath + "\\" + fileName);
                        fileItem.write(uploadFile);
                        posterUrl = fileName;
                    } // end if
                } // end if
            } // end for
        } catch (Exception e) {
            e.printStackTrace();
        }
        //파일 업로드 끝

        movie.setName(name);
        movie.setNameOrigin(nameOrigin);
        movie.setDate(date);
        movie.setGenre(genre);
        movie.setRunningTime(runningTime);
        movie.setAgeLimit(age);
        movie.setNation(nation);
        movie.setDetail(detail);
        movie.setPosterUrl(posterUrl);

        boolean result = service.insertMovie(movie);
        int movieNo = service.selectMovieByCondition(name, date, runningTime);
        movie.setMovieNo(movieNo);

        if (result) {
            request.setAttribute("movie", movie);
            request.setAttribute("msg", "add_success");
        } else {
            request.setAttribute("msg", "add_fail");
        }

        RequestDispatcher rd = request.getRequestDispatcher("moviedetail.jsp");
        rd.forward(request, response);
    }
}
