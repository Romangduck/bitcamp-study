// 49 로그인 및 외부키(Mysql 설정)
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
import project.myapp.handler.LoginListener;
import project.myapp.handler.MemberAddListener;
import project.myapp.handler.MemberDeleteListener;
import project.myapp.handler.MemberDetailListener;
import project.myapp.handler.MemberListListener;
import project.myapp.handler.MemberUpdateListener;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.Menu;
import project.util.MenuGroup;

public class ClientApp {

  public static Member loginUser;

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao opnionDao;
  BoardDao homeworkDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {

    Connection con = DriverManager.getConnection("jdbc:mysql://study:1111@localhost:3306/studydb" // JDBC
                                                                                                  // URL
    );

    this.memberDao = new MySQLMemberDao(con);
    this.opnionDao = new MySQLBoardDao(con, 1);
    this.boardDao = new MySQLBoardDao(con, 2);
    this.homeworkDao = new MySQLBoardDao(con, 3);

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
    System.out.println("학급 관리 시스템");
  }

  public void execute() {
    printTitle();

    new LoginListener(memberDao).service(prompt);

    mainMenu.execute(prompt);
  }



  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("학생 정보");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("학생 종합 의견");
    boardMenu.add(new Menu("등록", new BoardAddListener(opnionDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(opnionDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(opnionDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(opnionDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(opnionDao)));
    mainMenu.add(boardMenu);

    MenuGroup opnionMenu = new MenuGroup("자유 게시판");
    opnionMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    opnionMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    opnionMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    opnionMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    opnionMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(opnionMenu);

    MenuGroup homeworkMenu = new MenuGroup("숙제 게시판");
    homeworkMenu.add(new Menu("등록", new BoardAddListener(homeworkDao)));
    homeworkMenu.add(new Menu("목록", new BoardListListener(homeworkDao)));
    homeworkMenu.add(new Menu("조회", new BoardDetailListener(homeworkDao)));
    homeworkMenu.add(new Menu("변경", new BoardUpdateListener(homeworkDao)));
    homeworkMenu.add(new Menu("삭제", new BoardDeleteListener(homeworkDao)));
    mainMenu.add(homeworkMenu);

    // Menu helloMenu = new Menu("안녕!");
    // helloMenu.addActionListener(new HeaderListener());
    // helloMenu.addActionListener(new HelloLis tener());
    // helloMenu.addActionListener(new FooterListener());
    // mainMenu.add(helloMenu);
  }
}


