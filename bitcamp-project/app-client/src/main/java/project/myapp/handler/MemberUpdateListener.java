package project.myapp.handler;

import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberUpdateListener implements MemberActionListener {

  MemberDao memberDao;

  public MemberUpdateListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

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
    m.setLeftEye(prompt.inputFloat("왼쪽 시력? ", m.getLeftEye()));
    m.setRightEye(prompt.inputFloat("오른쪽 시력? ", m.getRightEye()));
    m.setHandPhone(prompt.inputInt("핸드폰 번호?", m.getHandPhone()));

    m.setGender(MemberActionListener.inputGender(m.getGender(), prompt));

    memberDao.update(m);
  }
}
