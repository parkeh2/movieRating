package com.movierating.controller.people;

import com.movierating.model.people.PeopleDTO;
import com.movierating.model.people.PeopleService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeopleAddServlet", value = "/people/add")
public class PeopleAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = "utf-8";
        request.setCharacterEncoding(encoding);

        String name = null;
        String profileImageUrl = null;

        String path = getServletContext().getRealPath("/images/people");
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
                        System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
                        name = fileItem.getString(encoding);
                    }
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
                        profileImageUrl = fileName;
                    } // end if
                } // end if
            } // end for
        } catch (Exception e) {
            e.printStackTrace();
        }
        //파일 업로드 끝

        PeopleService service = new PeopleService();
        PeopleDTO people = service.addPeople(name, profileImageUrl);
        request.setAttribute("people", people);
        request.setAttribute("pid", people.getPid());
        request.setAttribute("msg", "add_success");

        RequestDispatcher rd = request.getRequestDispatcher("peopledetail.jsp");
        rd.forward(request, response);
    }
}
