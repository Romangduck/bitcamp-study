package project.myapp;

import project.myapp.handler.MemberHandler;
import project.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();

    printMenu();

    while (true) {
      String menuNo = Prompt.inputString("메인> ");
      if (menuNo.equals("6")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        MemberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        MemberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        MemberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        MemberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        MemberHandler.deleteMember();
      } else {
        System.out.println(menuNo);
      }
    }

    Prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 정보등록");
    System.out.println("2. 인원목록");
    System.out.println("3. 정보조회");
    System.out.println("4. 정보변경");
    System.out.println("5. 등록정보삭제");
    System.out.println("6. 종료");
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
    System.out.println("----------------------------------");
  }
}
