package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public abstract class MemberListener implements ActionListener {

  protected List list;

  public MemberListener(List list) {
    this.list = list;

  }


  protected static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  protected Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  public void service(BreadcrumbPrompt prompt) {

  }



}
