package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.Iterator;
import project.util.List;

public class MemberListListener extends AbstractMemberListener {
  public MemberListListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("==========================================================");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("==========================================================");

    Iterator<Member> iterator = list.iterator();

    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f\n", m.getNo(), m.getName(),
          m.getAge(), m.getGender(), m.getHeight(), m.getWeight(), m.getLeftEye(), m.getRightEye());
    }
  }
}
