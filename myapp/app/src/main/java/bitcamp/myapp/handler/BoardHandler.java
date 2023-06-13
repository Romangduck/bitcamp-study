package bitcamp.myapp.handler;

import java.util.Date;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE];
  static int length = 0;

  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));

    boards[length++] = board;
  }

  public static void printBoard() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수 , 등록일 ");
    System.out.println("---------------------------------------");


    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      // 게시글의 등록일 값을 가져와서 Date 인스턴스에 저장한다.
      Date date = new Date(board.getCreatedDate());

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate(), date);
    }
  }

  public static void viewBoard() {
    String BoardNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      Date date = new Date(board.getCreatedDate());

      if (board.getNo() == Integer.parseInt(BoardNo)) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("조회수: %d\n", board.getViewCount());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("등록일: %tY-%tm-%td\n", date, date, date);
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }



  public static void updateBoard() {
    String BoardNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(BoardNo)) {
        System.out.printf("제목(%s)? ", board.getTitle());
        board.setTitle(Prompt.inputString(""));
        System.out.printf("작성자(%s)? ", board.getWriter());
        board.setWriter(Prompt.inputString(""));
        System.out.printf("새암호? ", board.getPassword());
        board.setPassword(Prompt.inputString(""));
        System.out.printf("새내용? ", board.getContent());
        board.setContent(Prompt.inputString(""));
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }



  public static void deleteBoard() {
    int BoardNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(BoardNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      boards[i] = boards[i + 1];
    }

    boards[--length] = null;
  }

  private static int indexOf(int BoardNo) {
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == BoardNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
