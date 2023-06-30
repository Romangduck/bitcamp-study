package project.myapp;

import project.myapp.handler.BoardHandler;
import project.myapp.handler.Handler;
import project.myapp.handler.MemberHandler;
import project.util.ArrayList;
import project.util.LinkedList;
import project.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt();

    Handler memberHandler = new MemberHandler(prompt, "대상자 정보", new ArrayList());
    Handler boardHandler = new BoardHandler(prompt, "자유게시판", new LinkedList());
    Handler complaintHandler = new BoardHandler(prompt, "민원", new LinkedList());

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute();
      } else if (menuNo.equals("3")) {
        complaintHandler.execute();

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 대상자 정보");
    System.out.println("2. 자유게시판");
    System.out.println("3. 민원");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
    System.out.println("----------------------------------");
  }
}
