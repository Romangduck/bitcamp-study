package project.myapp.handler;

import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.ActionListener;
import project.util.BreadcrumbPrompt;

public class MemberDetailListener implements ActionListener {

  MemberDao memberDao;

  public MemberDetailListener(MemberDao memberDao) {
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
    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("나이: %d\n", m.getAge());
    System.out.printf("성별: %s\n", m.getGender() == 'M' ? "남성" : "여성");
    System.out.printf("키: %d\n", m.getHeight());
    System.out.printf("몸무게 : %d\n", m.getWeight());
    System.out.printf("왼쪽 시력: %.1f\n", m.getLeftEye());
    System.out.printf("오른쪽 시력: %.1f\n", m.getRightEye());
  }
}

