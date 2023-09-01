package project.myapp.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import project.myapp.dao.BoardDao;
import project.myapp.vo.Board;
import project.util.ActionListener;
import project.util.BreadcrumbPrompt;

public class BoardListListener implements ActionListener {

  BoardDao boardDao;
  SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

  public BoardListListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    prompt.println("---------------------------------------");
    prompt.println("번호, 제목, 작성자, 조회수, 등록일");
    prompt.println("---------------------------------------");

    List<Board> list = boardDao.list();

    for (Board board : list) {
      prompt.printf("%d, %s, %s, %d, %s\n", board.getNo(), board.getTitle(),
          board.getWriter().getName(), board.getViewCount(),
          dateFormatter.format(board.getCreatedDate()));
    }
  }

}


