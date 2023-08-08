package project.myapp.handler;

import project.myapp.ClientApp;
import project.myapp.dao.BoardDao;
import project.myapp.vo.Board;
import project.util.ActionListener;
import project.util.BreadcrumbPrompt;

public class BoardAddListener implements ActionListener {

  BoardDao boardDao;

  public BoardAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(ClientApp.loginUser);

    boardDao.insert(board);
  }
}


