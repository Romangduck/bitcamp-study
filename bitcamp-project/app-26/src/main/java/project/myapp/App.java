package project.myapp; //34

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import project.myapp.handler.BoardAddListener;
import project.myapp.handler.BoardDeleteListener;
import project.myapp.handler.BoardDetailListener;
import project.myapp.handler.BoardListListener;
import project.myapp.handler.BoardUpdateListener;
import project.myapp.handler.FooterListener;
import project.myapp.handler.HeaderListener;
import project.myapp.handler.HelloListener;
import project.myapp.handler.MemberAddListener;
import project.myapp.handler.MemberDeleteListener;
import project.myapp.handler.MemberDetailListener;
import project.myapp.handler.MemberListListener;
import project.myapp.handler.MemberUpdateListener;
import project.myapp.vo.Board;
import project.myapp.vo.CsvObject;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.Menu;
import project.util.MenuGroup;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> complaintList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {

    loadCsv("member.csv", memberList, Member.class);
    loadCsv("board.csv", boardList, Board.class);
    loadCsv("complaint.csv", complaintList, Board.class);
  }

  private void saveData() {
    saveCsv("member.csv", memberList);
    saveCsv("board.csv", boardList);
    saveCsv("complaint.csv", complaintList);
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("대상자 정보");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberList)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("자유게시판");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("민원");
    readingMenu.add(new Menu("등록", new BoardAddListener(complaintList)));
    readingMenu.add(new Menu("목록", new BoardListListener(complaintList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(complaintList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(complaintList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(complaintList)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }

  @SuppressWarnings("unchecked")

  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);
      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line));
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0);
      PrintWriter out = new PrintWriter(out1);

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());

      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
