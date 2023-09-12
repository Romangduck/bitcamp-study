package project.myapp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/form")
public class MemberFormServlet extends HttpServlet {

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
        out.println("<title>비트병원</title>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("/header").include(request, response);

        out.println("<h1>회원</h1>");
        out.println("<form action='/member/add' method='post' enctype='multipart/form-data'>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("  <th>이름</th> <td style='width:200px;'><input type='text' name='name'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>핸드폰 번호</th> <td><input type='handPhone' name='handPhone'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>비밀 번호</th> <td><input type='password' name='password'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>성별</th> ");
        out.println("  <td>");
        out.println("    <select name='gender'>");
        out.println("      <option value='M'>남자</option>");
        out.println("      <option value='W'>여자</option>");
        out.println("    </select>  ");
        out.println("  </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>생년월일</th> <td><input type='age' name='age'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>키</th> <td><input type='height' name='height'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>몸무게</th> <td><input type='weight' name='weight'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>왼쪽 시력</th> <td><input type='leftEye' name='leftEye'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>오른쪽 시력</th> <td><input type='rightEye' name='rightEye'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("  <th>사진</th> <td><input type='file' name='photo'></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<button>등록</button>");
        out.println("</form>");

        request.getRequestDispatcher("/footer").include(request, response);

        out.println("</body>");
        out.println("</html>");

    }
}











