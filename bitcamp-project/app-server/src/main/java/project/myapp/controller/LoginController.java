package project.myapp.controller;

import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/login")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/jsp/auth/form.jsp").include(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Member m = new Member();
        m.setHandPhone(request.getParameter("handPhone"));
        m.setPassword(request.getParameter("password"));

        if(request.getParameter("saveHandPhone")!= null) {
            Cookie cookie = new Cookie("handPhone",m.getHandPhone());
            response.addCookie(cookie);
        } else {

            Cookie cookie = new Cookie("handPhone" ,"no");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("boardDao");

        Member loginUser = memberDao.findByPhoneNumberAndPassword(m);
        if (loginUser != null) {
            // 로그인 정보를 다른 요청에서도 사용할 있도록 세션 보관소에 담아 둔다.
            request.getSession().setAttribute("loginUser", loginUser);
            response.sendRedirect("/");
            return;
        }

        request.setAttribute("refresh","2;url=/auth/login");
        throw new ServletException("회원 정보가 일치하지 않습니다");

    }
}
