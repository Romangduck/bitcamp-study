package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.List;

public class MemberUpdateListener extends AbstractMemberListener {

  public MemberUpdateListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    int memberNo = prompt.inputInt("번호? ");

    Member m = (Member) this.findBy(memberNo);
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

    m.setGender(inputGender(m.getGender(), prompt));
  }
}
