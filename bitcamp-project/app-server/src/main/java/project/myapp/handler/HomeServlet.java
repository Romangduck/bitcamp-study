package project.myapp.handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>비트병원</title>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("/header").include(request, response);

        out.println("<h1>BitHP</h1>");
        out.println("<p>실습 프로젝트 입니다</p>");

        request.getRequestDispatcher("/footer").include(request, response);

        out.println("</body>");
        out.println("</html>");
    }
}


