package project.myapp.handler;

import java.io.IOException;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class LoginListener implements MemberActionListener {

  MemberDao memberDao;

  public LoginListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    while (true) {
      Member m = new Member();
      m.setHandPhone(prompt.inputString("핸드폰번호? "));
      m.setPassword(prompt.inputString("암호? "));

      Member loginUser = memberDao.findByPhoneNumberAndPassword(m);
      if (loginUser == null) {
        System.out.println("회원 정보가 일치하지 않습니다.");
      } else {
        prompt.setAttribute("loginUser", loginUser);
        break;
      }
    }
  }
}
