package project.myapp;

import project.myapp.handler.BoardHandler;
import project.myapp.handler.MemberHandler;
import project.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt();

    MemberHandler memberHandler = new MemberHandler(prompt);
    BoardHandler boardHandler = new BoardHandler(prompt);

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("99")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        memberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        memberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        memberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        memberHandler.deleteMember();
      } else if (menuNo.equals("6")) {
        boardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        boardHandler.printBoard();
      } else if (menuNo.equals("8")) {
        boardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        boardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        boardHandler.deleteBoard();

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 정보등록");
    System.out.println("2. 인원목록");
    System.out.println("3. 정보조회");
    System.out.println("4. 정보변경");
    System.out.println("5. 등록정보삭제");
    System.out.println("6. 게시글등록");
    System.out.println("7. 게시글목록");
    System.out.println("8. 게시글조회");
    System.out.println("9. 게시글변경");
    System.out.println("10. 게시글삭제");
    System.out.println("99. 종료");
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
    System.out.println("----------------------------------");
  }
}