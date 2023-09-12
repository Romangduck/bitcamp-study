package project.myapp.controller;

import org.apache.ibatis.session.SqlSessionFactory;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.NcpObjectStorageService;

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
    protected void doGet(HttpServletRequest request , HttpServletResponse response)
        throws  ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/jsp/member/from.jsp").include(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        NcpObjectStorageService ncpObjectStorageService = (NcpObjectStorageService) this.getServletContext().getAttribute("ncpObjectStorageServcice");
        MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");

        try {

        Member m = new Member();
        m.setName(request.getParameter("name"));
        m.setHandPhone(request.getParameter("handPhone"));
        m.setPassword(request.getParameter("password"));
        m.setGender(request.getParameter("gender").charAt(0));
        m.setAge(Integer.parseInt(request.getParameter("age")));
        m.setHeight(Integer.parseInt(request.getParameter("height")));
        m.setWeight(Integer.parseInt(request.getParameter("weight")));
        m.setLeftEye(Float.parseFloat(request.getParameter("leftEye")));
        m.setRightEye(Float.parseFloat(request.getParameter("rightEye")));



        Part photoPart = request.getPart("photo");
        if (photoPart.getSize() > 0) {
            String uploadFileUrl = ncpObjectStorageService.uploadFile(
                    "bitcamp-nc7-bucket-24", "member2/", photoPart);
            m.setPhoto(uploadFileUrl);
        }
        memberDao.insert(m);
        sqlSessionFactory.openSession(false).commit();
        response.sendRedirect("list");

    } catch (Exception e) {
        sqlSessionFactory.openSession(false).rollback();
        request.setAttribute("message", "회원 등록 오류!");
        request.setAttribute("refresh", "2;url=list");
        throw new ServletException(e);
    }
}
    }
