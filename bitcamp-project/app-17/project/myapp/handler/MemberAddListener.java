package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.List;

public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setAge(Integer.parseInt(prompt.inputString("나이? ")));
    m.setGender(inputGender((char) 0, prompt));
    m.setHeight(Integer.parseInt(prompt.inputString("키? ")));
    m.setWeight(Integer.parseInt(prompt.inputString("몸무게? ")));
    m.setLeftEye(Float.parseFloat(prompt.inputString("시력(왼쪽)? ")));
    m.setRightEye(Float.parseFloat(prompt.inputString("시력(오른쪽)? ")));

    this.list.add(m);
  }
}
