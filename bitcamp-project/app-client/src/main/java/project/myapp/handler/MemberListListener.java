package project.myapp.handler;

import java.util.List;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.ActionListener;
import project.util.BreadcrumbPrompt;

public class MemberListListener implements ActionListener {


  MemberDao memberDao;

  public MemberListListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("==========================  ================================");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력 , 핸드폰");
    System.out.println("==========================================================");

    List<Member> list = memberDao.list();

    for (Member m : list) {
      System.out.printf("%d, %s, %d, %s , %d, %d, %.1f , %.1f,%d \n", m.getNo(), m.getName(),
          m.getAge(), m.getGender() == 'M' ? "남성" : "여성", m.getHeight(), m.getWeight(),
          m.getLeftEye(), m.getRightEye(), m.getHandPhone());
    }
  }
}
