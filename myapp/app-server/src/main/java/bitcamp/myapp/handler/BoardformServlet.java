package bitcamp.myapp.handler;

import java.io.PrintWriter;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/board/form")
public class BoardformServlet implements Servlet {

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int category = Integer.parseInt(request.getParameter("category"));


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();



  }
}


