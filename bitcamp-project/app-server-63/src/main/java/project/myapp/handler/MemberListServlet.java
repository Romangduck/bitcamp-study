package project.myapp.controller;

import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>회원</title>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("/header").include(request, response);

        out.println("<h1>회원 목록</h1>");
        out.println("<div style='margin:5px;'>");
        out.println("<a href='/member/form'>새 회원</a>");
        out.println("</div>");
        out.println("<table border='1'>");
        out.println("<thead>");
        out.println("  <tr><th>번호</th> <th>이름</th> <th>생년월일</th> <th>성별</th> <th>핸드폰 번호</th></tr>");
        out.println("</thead>");

        MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");

        List<Member> list = memberDao.findAll();
        for (Member m : list) {
            out.printf("<tr>"
                            + " <td>%d</td>"
                            + " <td>"
                            + "<img src='http://bnpxdrusesip19010743.cdn.ntruss.com/member2/%s?type=f&w=30&h=40&faceopt=true&ttype=jpg'>"
                            + "<a href='/member/detail?no=%d'>%s</a></td>"
                            + " <td>%d</td>"
                            + "<td>%c</td>"
                            + "<td>%s</td></tr>\n",

                    m.getNo(), m.getPhoto(), m.getNo(), m.getName(), m.getAge(), m.getGender(), m.getHandPhone());
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("<a href='/'>메인</a>");

        request.getRequestDispatcher("/footer").include(request, response);

        out.println("</body>");
        out.println("</html>");
    }

}