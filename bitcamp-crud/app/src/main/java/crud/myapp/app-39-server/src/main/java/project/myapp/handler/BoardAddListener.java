package project.myapp.handler;

import java.io.IOException;
import project.myapp.dao.BoardDao;
import project.myapp.vo.Board;
import project.myapp.vo.Member;
import project.util.ActionListener;
import project.util.BreadcrumbPrompt;

public class BoardAddListener implements ActionListener {

  BoardDao boardDao;

  public BoardAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter((Member) prompt.getAttribute("loginUser"));

    boardDao.insert(board);
  }
}


