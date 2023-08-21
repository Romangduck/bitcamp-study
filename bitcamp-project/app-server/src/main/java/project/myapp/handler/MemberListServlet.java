package project.myapp.handler;

import java.io.PrintWriter;
import java.util.List;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.Component;
import project.util.HttpServletRequest;
import project.util.HttpServletResponse;
import project.util.Servlet;

@Component("/member/list")
public class MemberListServlet implements Servlet {

  MemberDao memberDao;

  public MemberListServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 목록</h1>");
    out.println("<div style='margin:5px;'>");
    out.println("<a href='/member/form.html'>새 회원</a>");
    out.println("</div>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("  <tr><th>번호</th> <th>이름</th> <th>나이</th> <th>성별</th> <th>핸드폰</th></tr>");
    out.println("</thead>");

    List<Member> list = memberDao.findAll();
    for (project.myapp.vo.Member m : list) {
      out.printf(
          "<tr>" + " <td>%d</td>" + " <td><a href='/member/detail?no=%d'>%s</a></td>"
              + " <td>%s</td>" + "<td>%d</td>" + "<td>%c</td>" + "<td>%d</td></tr>\n",
          m.getNo(), m.getNo(), m.getName(), m.getAge(), m.getGender(), m.getHandPhone());
    }

    out.println("</tbody>");
    out.println("</table>");
    out.println("<a href='/'>메인</a>");
    out.println("</body>");
    out.println("</html>");
  }

}
