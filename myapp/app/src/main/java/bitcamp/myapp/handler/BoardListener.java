package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.List;

public abstract class BoardListener implements ActionListener {

  protected List list;

  public BoardListener(List list) {
    this.list = list;

  }

  protected Board findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  // public void service(BreadcrumbPrompt prompt) {
  //
  // } 추상 클래스는 미완성된 클래스이기때문에 일부 메서드가 구현되지 않은채로 있어도됨

}
