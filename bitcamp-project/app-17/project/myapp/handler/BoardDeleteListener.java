package project.myapp.handler;

import project.myapp.vo.Board;
import project.util.BreadcrumbPrompt;
import project.util.List;

public class BoardDeleteListener extends AbstractBoardListener {

  public BoardDeleteListener(List<Board> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Board(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}


