package project.myapp.handler;

import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Member m = new Member();
        m.setHandPhone(request.getParameter("handPhone"));
        m.setPassword(request.getParameter("password"));
        MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("boardDao");

        Member loginUser = memberDao.findByPhoneNumberAndPassword(m);
        if (loginUser != null) {
            // 로그인 정보를 다른 요청에서도 사용할 있도록 세션 보관소에 담아 둔다.
            request.getSession().setAttribute("loginUser", loginUser);
            response.sendRedirect("/");
            return;
        }

        request.setAttribute("message", "회원 정보가 일치하지 않습니다.");
        request.setAttribute("refresh", "1;url=/auth/form.html");

        request.getRequestDispatcher("/error").forward(request, response);
    }
}
