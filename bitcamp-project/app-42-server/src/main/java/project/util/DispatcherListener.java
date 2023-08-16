package project.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import project.dao.MySQLBoardDao;
import project.dao.MySQLMemberDao;
import project.myapp.dao.BoardDao;
import project.myapp.dao.MemberDao;
import project.myapp.handler.BoardAddListener;
import project.myapp.handler.BoardDeleteListener;
import project.myapp.handler.BoardDetailListener;
import project.myapp.handler.BoardListListener;
import project.myapp.handler.BoardUpdateListener;
import project.myapp.handler.LoginListener;
import project.myapp.handler.MemberAddListener;
import project.myapp.handler.MemberDeleteListener;
import project.myapp.handler.MemberDetailListener;
import project.myapp.handler.MemberListListener;
import project.myapp.handler.MemberUpdateListener;

public class DispatcherListener implements ActionListener {

  // 객체 보관소
  Map<String, Object> beanContainer = new HashMap<>();

  public DispatcherListener() throws Exception {

    // Mybatis 준비
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("project/myapp/config/mybatis-config.xml")));
    beanContainer.put("sqlSessionFactory", sqlSessionFactory);

    // DAO 준비
    MemberDao memberDao = new MySQLMemberDao(sqlSessionFactory);
    BoardDao boardDao = new MySQLBoardDao(sqlSessionFactory);
    beanContainer.put("memberDao", memberDao);
    beanContainer.put("boardDao", boardDao);

    // Listener 준비
    beanContainer.put("login", new LoginListener(memberDao));

    beanContainer.put("member/add", new MemberAddListener(memberDao, sqlSessionFactory));
    beanContainer.put("member/list", new MemberListListener(memberDao));
    beanContainer.put("member/detail", new MemberDetailListener(memberDao));
    beanContainer.put("member/update", new MemberUpdateListener(memberDao, sqlSessionFactory));
    beanContainer.put("member/delete", new MemberDeleteListener(memberDao, sqlSessionFactory));

    beanContainer.put("opnion/add", new BoardAddListener(1, boardDao, sqlSessionFactory));
    beanContainer.put("opnion/list", new BoardListListener(1, boardDao));
    beanContainer.put("opnion/detail", new BoardDetailListener(1, boardDao, sqlSessionFactory));
    beanContainer.put("opnion/update", new BoardUpdateListener(1, boardDao, sqlSessionFactory));
    beanContainer.put("opnion/delete", new BoardDeleteListener(1, boardDao, sqlSessionFactory));

    beanContainer.put("board/add", new BoardAddListener(2, boardDao, sqlSessionFactory));
    beanContainer.put("board/list", new BoardListListener(2, boardDao));
    beanContainer.put("board/detail", new BoardDetailListener(2, boardDao, sqlSessionFactory));
    beanContainer.put("board/update", new BoardUpdateListener(2, boardDao, sqlSessionFactory));
    beanContainer.put("board/delete", new BoardDeleteListener(2, boardDao, sqlSessionFactory));

    beanContainer.put("homework/add", new BoardAddListener(3, boardDao, sqlSessionFactory));
    beanContainer.put("homework/list", new BoardListListener(3, boardDao));
    beanContainer.put("homework/detail", new BoardDetailListener(3, boardDao, sqlSessionFactory));
    beanContainer.put("homework/update", new BoardUpdateListener(3, boardDao, sqlSessionFactory));
    beanContainer.put("homework/delete", new BoardDeleteListener(3, boardDao, sqlSessionFactory));
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    ActionListener listener = (ActionListener) beanContainer.get(prompt.getAttribute("menuPath"));
    if (listener == null) {
      throw new RuntimeException("해당 요청을 처리할 수 없습니다.");
    }
    listener.service(prompt);
  }

  public Object getBean(String name) {
    return beanContainer.get(name);
  }
}
