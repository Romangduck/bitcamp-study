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
    menu.append("1. 대상자 정보\n");
    menu.append("2. 자유게시판\n");
    menu.append("3. 민원\n");
    menu.append("0. 종료\n");
    return menu.toString();
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
    System.out.println("----------------------------------");
  }
}
