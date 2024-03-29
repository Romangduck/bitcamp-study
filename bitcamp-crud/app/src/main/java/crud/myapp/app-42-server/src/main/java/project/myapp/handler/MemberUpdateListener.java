package project.myapp.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberUpdateListener implements MemberActionListener {

  MemberDao memberDao;
  SqlSessionFactory sqlSessionFactory;

  public MemberUpdateListener(MemberDao memberDao, SqlSessionFactory sqlSessionFactory) {
    this.memberDao = memberDao;
    this.sqlSessionFactory = sqlSessionFactory;

  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {

    int memberNo = prompt.inputInt("번호? ");

    Member m = memberDao.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    m.setName(prompt.inputString("이름(%s)?", m.getName()));

    m.setAge(prompt.inputInt("나이? ", m.getAge()));
    m.setHeight(prompt.inputInt("키? ", m.getHeight()));
    m.setWeight(prompt.inputInt("몸무게? ", m.getWeight()));
    m.setGender(MemberActionListener.inputGender(m.getGender(), prompt));
    m.setLeftEye(prompt.inputFloat("왼쪽 시력? ", m.getLeftEye()));
    m.setRightEye(prompt.inputFloat("오른쪽 시력? ", m.getRightEye()));
    m.setHandPhone(prompt.inputString("핸드폰 번호?", m.getHandPhone()));
    m.setPassword(prompt.inputString("새암호? "));


    try {
      memberDao.update(m);
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}

