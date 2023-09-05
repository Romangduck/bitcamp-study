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


@WebServlet("/member/update")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class MemberUpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setAge(Integer.parseInt(request.getParameter("age")));
    member.setHeight(Integer.parseInt(request.getParameter("height")));
    member.setWeight(Integer.parseInt(request.getParameter("weight")));
    member.setLeftEye(Float.parseFloat(request.getParameter("leftEye")));
    member.setRightEye(Float.parseFloat(request.getParameter("rightEye")));
    member.setGender(request.getParameter("gender").charAt(0));
    member.setHandPhone(request.getParameter("handPhone"));
    member.setPassword(request.getParameter("password"));

        Part photoPart = request.getPart("photo");
        if (photoPart.getSize() > 0) {
            String uploadFileUrl = InitServlet.ncpObjectStorageService.uploadFile(
                    "bitcamp-nc7-bucket-24", "member2/", photoPart);
            member.setPhoto(uploadFileUrl);
        }
        try {
            if (InitServlet.memberDao.update(member) == 0) {
                throw new Exception("회원이 없습니다.");
            } else {
                InitServlet.sqlSessionFactory.openSession(false).commit();
                response.sendRedirect("list");
            }
        } catch (Exception e) {
            InitServlet.sqlSessionFactory.openSession(false).rollback();

            request.setAttribute("error", e);
            request.setAttribute("message", e.getMessage());
            request.setAttribute("refresh", "2;url=list");

            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
}

