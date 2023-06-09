package project.myapp.handler;

import java.util.List;
import project.myapp.vo.Board;
import project.util.ActionListener;

public abstract class AbstractBoardListener implements ActionListener {

  protected List<Board> list;

  public AbstractBoardListener(List<Board> list) {
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
