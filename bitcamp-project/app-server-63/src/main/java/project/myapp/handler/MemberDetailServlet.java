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

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");

      Member member = memberDao.findBy(Integer.parseInt(request.getParameter("no")));

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

    out.println("<h1>회원</h1>");

    if (member == null) {
      out.println("<p>해당 번호의 회원이 없습니다!</p>");

    } else {
        out.println("<form action='/member/update' method='post' enctype='multipart/form-data'>");
      out.println("<table border='1'>");
        out.printf("<tr><th style='width:120px;'>사진</th>"
                + " <td style='width:300px;'>"
                + (member.getPhoto() == null ? "<img style='height:80px' src='/images/avatar.png'>" :
                "<a href='https://kr.object.ncloudstorage.com/bitcamp-nc7-bucket-24/member2/%s'>"
                        + "<img src='http://bnpxdrusesip19010743.cdn.ntruss.com/member2/%1$s?type=f&w=60&h=80&faceopt=true&ttype=jpg'>"
                        + "</a>")
                + " <input type='file' name='photo'>"
                + "</td></tr>\n", member.getPhoto());
      out.printf("<tr><th style='width:120px;'>번호</th>"
          + " <td style='width:300px;'><input type='text' name='no' value='%d' readonly></td></tr>\n",
          member.getNo());
      out.printf("<tr><th>이름</th>" + " <td><input type='text' name='name' value='%s'></td></tr>\n",
          member.getName());
      out.printf("<tr><th>생년월일</th>" + " <td><input type='age' name='age' value='%d'></td></tr>\n",
          member.getAge());
      out.printf(
          "<tr><th>성별</th>\n" + " <td><select name='gender'>\n"
              + " <option value='M' %s>남자</option>\n"
              + " <option value='W' %s>여자</option></select></td></tr>\n",
          (member.getGender() == 'M' ? "selected" : ""),
          (member.getGender() == 'W' ? "selected" : ""));
      out.printf("<tr><th>키</th>" + " <td><input type='height' name='height' value='%d'></td></tr>\n",
          member.getHeight());
      out.printf("<tr><th>몸무게</th>" + " <td><input type='weight' name='weight' value='%d'></td></tr>\n",
          member.getWeight());
      out.printf("<tr><th>왼쪽 시력</th>" + " <td><input type='leftEye' name='leftEye' value='%.1f'></td></tr>\n",
          member.getLeftEye());
      out.printf("<tr><th>오른쪽 시력</th>" + " <td><input type='rightEye' name='rightEye' value='%.1f'></td></tr>\n",
          member.getRightEye());
        out.printf("<tr><th>핸드폰 번호</th>" + " <td><input type='handPhone' name='handPhone' value='%s'></td></tr>\n",
                member.getHandPhone());
        out.printf("<tr><th>비밀 번호</th>" + " <td><input type='password' name='password' value='%s'></td></tr>\n",
                member.getPassword());
      out.println("</table>");

      out.println("<div>");
      out.println("<button>변경</button>");
      out.println("<button type='reset'>초기화</button>");
      out.printf("<a href='/member/delete?no=%d'>삭제</a>\n", member.getNo());
      out.println("<a href='/member/list'>목록</a>\n");
      out.println("</div>");
      out.println("</form>");
    }


      request.getRequestDispatcher("/footer").include(request, response);

      out.println("</body>");
      out.println("</html>");

  }
}