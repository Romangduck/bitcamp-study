package project.myapp.handler;

import project.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/member/add")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class MemberAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Member m = new Member();
        m.setName(request.getParameter("name"));
        m.setHandPhone(request.getParameter("handPhone"));
        m.setPassword(request.getParameter("password"));
        m.setGender(request.getParameter("gender").charAt(0));

        Part photoPart = request.getPart("photo");
        if (photoPart.getSize() > 0) {
            String uploadFileUrl = InitServlet.ncpObjectStorageService.uploadFile(
                    "bitcamp-nc7-bucket-24", "member2/", photoPart);
            m.setPhoto(uploadFileUrl);
        }


        try {
            InitServlet.memberDao.insert(m);
            InitServlet.sqlSessionFactory.openSession(false).commit();
            response.sendRedirect("list");

        } catch (Exception e) {
            InitServlet.sqlSessionFactory.openSession(false).rollback();

            request.setAttribute("error", e);
            request.setAttribute("message", "회원 등록 오류!");
            request.setAttribute("refresh", "2;url=list");

            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
}

