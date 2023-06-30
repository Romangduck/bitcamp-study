package project.myapp;

import project.myapp.handler.BoardHandler;
import project.myapp.handler.Handler;
import project.myapp.handler.MemberHandler;
import project.util.ArrayList;
import project.util.LinkedList;
import project.util.MenuPrompt;

public class App {

  public static void main(String[] args) {
    MenuPrompt prompt = new MenuPrompt();
    prompt.appendBreadcrumb("메인", getMenu());

    Handler memberHandler = new MemberHandler(prompt, "대상자 정보", new ArrayList());
    Handler boardHandler = new BoardHandler(prompt, "자유게시판", new LinkedList());
    Handler complaintHandler = new BoardHandler(prompt, "민원", new LinkedList());

    printTitle();

    prompt.printMenu();

    loop: while (true) {
      String menuNo = prompt.inputMenu();
      switch (menuNo) {
        case "0":
          break loop;
        case "1":
          memberHandler.execute();
          break;
        case "2":
          boardHandler.execute();
          break;
        case "3":
          complaintHandler.execute();
          break;
      }
    }
    prompt.close();
  }

  static String getMenu() {
    StringBuilder menu = new StringBuilder();
    System.out.println("1. 대상자 정보");
    System.out.println("2. 자유게시판");
    System.out.println("3. 민원");
    System.out.println("0. 종료");
    return menu.toString();
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
    System.out.println("----------------------------------");
  }
}
