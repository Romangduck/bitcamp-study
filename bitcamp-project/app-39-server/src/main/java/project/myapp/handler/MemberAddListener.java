package project.myapp.handler;

import java.io.IOException;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberAddListener implements MemberActionListener {

  MemberDao memberDao;

  public MemberAddListener(MemberDao memberDao) {
    this.memberDao = memberDao;
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

    memberDao.insert(m);
  }
}

