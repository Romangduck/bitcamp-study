package project.myapp.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberAddListener implements MemberActionListener {

  MemberDao memberDao;
  SqlSessionFactory sqlSessionFactory;

  public MemberAddListener(MemberDao memberDao, SqlSessionFactory sqlSessionFactory) {
    this.memberDao = memberDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setAge(Integer.parseInt(prompt.inputString("나이? ")));
    m.setGender(MemberActionListener.inputGender((char) 0, prompt));
    m.setHeight(Integer.parseInt(prompt.inputString("키? ")));
    m.setWeight(Integer.parseInt(prompt.inputString("몸무게? ")));
    m.setLeftEye(Float.parseFloat(prompt.inputString("시력(왼쪽)? ")));
    m.setRightEye(Float.parseFloat(prompt.inputString("시력(오른쪽)? ")));
    m.setHandPhone(prompt.inputString("핸드폰 번호?"));
    m.setPassword(prompt.inputString("암호? "));



    try {
      memberDao.insert(m);
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }
}

