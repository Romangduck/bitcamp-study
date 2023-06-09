package project.myapp.handler;

import project.myapp.vo.Board;
import project.util.ActionListener;
import project.util.List;

public abstract class AbstractBoardListener implements ActionListener {

  protected List list;

  public AbstractBoardListener(List list) {
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

}
