package bitcamp.myapp.handler;

import java.util.Date;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {


  // 인스턴스에 상관없이 공통으로 사용하는 필드라면 스태틱 필드로 선언한다.
  private static final int MAX_SIZE = 100;

  // 인스턴스 마다 별개로 관리해야 할 데이터라면 논스태틱 필드로 선언한다.
  private Board[] boards = new Board[MAX_SIZE];
  private int length = 0;


  // 인스턴스 멤버(필드나 메서드)를 사용하는 경우 인스턴스 메서드로 정의해야한다.
  public void inputBoard() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));

    this.boards[this.length++] = board;
  }

  public void printBoard() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수 , 등록일 ");
    System.out.println("---------------------------------------");


    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];

      // 게시글의 등록일 값을 가져와서 Date 인스턴스에 저장한다.
      Date date = new Date(board.getCreatedDate());

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate(), date);
    }
  }

  public void viewBoard() {
    String BoardNo = Prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];

      Date date = new Date(board.getCreatedDate());

      if (board.getNo() == Integer.parseInt(BoardNo)) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("조회수: %d\n", board.getViewCount());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("등록일: %tY-%tm-%td\n", date, date, date);
        board.setViewCount(board.getViewCount() + 1);
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }



  public void updateBoard() {
    String BoardNo = Prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == Integer.parseInt(BoardNo)) {
        if (Prompt.inputString("암호? ").equals(board.getPassword())) {
          System.out.println("암호가 일치하지 않습니다 !");
          return;
        }
        System.out.printf("제목(%s)? ", board.getTitle());
        board.setTitle(Prompt.inputString(""));

        System.out.printf("내용? ", board.getContent());
        board.setContent(Prompt.inputString(""));
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }



  public void deleteBoard() {
    int BoardNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(BoardNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.boards[i] = this.boards[i + 1];
    }

    this.boards[--this.length] = null;
  }

  private int indexOf(int BoardNo) {
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == BoardNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
