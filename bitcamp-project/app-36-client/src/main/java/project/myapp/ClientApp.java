// 46
package project.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import project.dao.MySQLBoardDao;
import project.dao.MySQLMemberDao;
import project.myapp.dao.BoardDao;
import project.myapp.dao.MemberDao;
import project.myapp.handler.BoardAddListener;
import project.myapp.handler.BoardDeleteListener;
import project.myapp.handler.BoardDetailListener;
import project.myapp.handler.BoardListListener;
import project.myapp.handler.BoardUpdateListener;
import project.myapp.handler.MemberAddListener;
import project.myapp.handler.MemberDeleteListener;
import project.myapp.handler.MemberDetailListener;
import project.myapp.handler.MemberListListener;
import project.myapp.handler.MemberUpdateListener;
import project.util.BreadcrumbPrompt;
import project.util.Menu;
import project.util.MenuGroup;

public class ClientApp {

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao complaintDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {

    Connection con = DriverManager.getConnection("jdbc:mysql://study:1111@localhost:3306/studydb" // JDBC
                                                                                                  // URL
    );

    this.memberDao = new MySQLMemberDao(con);
    this.boardDao = new MySQLBoardDao(con, 1);
    this.complaintDao = new MySQLBoardDao(con, 2);

    prepareMenu();
  }

  public void close() throws Exception {
    prompt.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("실행 예) java ... bitcamp.myapp.ClientApp 서버주소 포트번호");
      return;
    }

    ClientApp app = new ClientApp(args[0], Integer.parseInt(args[1]));
    app.execute();
    app.close();
  }

  static void printTitle() {
    System.out.println("신체 검사 정보 관리");
  }

  public void execute() {
    printTitle();
    mainMenu.execute(prompt);
  }



  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("대상자 정보");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("자유게시판");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);

    MenuGroup complaintMenu = new MenuGroup("민원");
    complaintMenu.add(new Menu("등록", new BoardAddListener(complaintDao)));
    complaintMenu.add(new Menu("목록", new BoardListListener(complaintDao)));
    complaintMenu.add(new Menu("조회", new BoardDetailListener(complaintDao)));
    complaintMenu.add(new Menu("변경", new BoardUpdateListener(complaintDao)));
    complaintMenu.add(new Menu("삭제", new BoardDeleteListener(complaintDao)));
    mainMenu.add(complaintMenu);

    // Menu helloMenu = new Menu("안녕!");
    // helloMenu.addActionListener(new HeaderListener());
    // helloMenu.addActionListener(new HelloListener());
    // helloMenu.addActionListener(new FooterListener());
    // mainMenu.add(helloMenu);
  }
}


