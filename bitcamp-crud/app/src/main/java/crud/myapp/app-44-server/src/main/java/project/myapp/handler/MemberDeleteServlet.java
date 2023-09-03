package project.myapp.handler;

import org.apache.ibatis.session.SqlSessionFactory;
import project.myapp.dao.MemberDao;
import project.util.Component;
import project.util.HttpServletRequest;
import project.util.HttpServletResponse;
import project.util.Servlet;

@Component("/member/delete")
public class MemberDeleteServlet implements Servlet {

  MemberDao memberDao;
  SqlSessionFactory sqlSessionFactory;

  public MemberDeleteServlet(MemberDao memberDao, SqlSessionFactory sqlSessionFactory) {
    this.memberDao = memberDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      if (memberDao.delete(Integer.parseInt(request.getParameter("no"))) == 0) {
        throw new Exception("해당 번호의 회원이 없습니다.");
      } else {
        response.sendRedirect("/member/list");
      }
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}