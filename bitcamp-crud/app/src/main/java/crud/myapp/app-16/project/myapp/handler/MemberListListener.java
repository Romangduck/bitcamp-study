package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.List;

public class MemberListListener extends AbstractMemberListener {
  public MemberListListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("==========================================================");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("==========================================================");

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f\n", m.getNo(), m.getName(),
          m.getAge(), m.getGender(), m.getHeight(), m.getWeight(), m.getLeftEye(), m.getRightEye());
    }
  }
}
