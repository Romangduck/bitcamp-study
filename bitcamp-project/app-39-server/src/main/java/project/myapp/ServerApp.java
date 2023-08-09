// 50 Executor를 이용하여 스레드를 풀링하기
package project.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import project.net.NetProtocol;
import project.util.BreadcrumbPrompt;
import project.util.Menu;
import project.util.MenuGroup;

public class ServerApp {

  ExecutorService threadPool = Executors.newFixedThreadPool(10);

  Connection con;
  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao opnionDao;
  BoardDao homeworkDao;

  int port;

  MenuGroup mainMenu = new MenuGroup("메인");

  public ServerApp(int port) throws Exception {

    con = DriverManager.getConnection("jdbc:mysql://study:1111@localhost:3306/studydb" // JDBC
                                                                                       // URL
    );

    this.memberDao = new MySQLMemberDao(con);
    this.opnionDao = new MySQLBoardDao(con, 1);
    this.boardDao = new MySQLBoardDao(con, 2);
    this.homeworkDao = new MySQLBoardDao(con, 3);

    prepareMenu();
  }

  public void close() throws Exception {
    con.close();
  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp(8888);
    app.execute();
    app.close();
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        Socket socket = serverSocket.accept();
        threadPool.execute(() -> processRequest(socket));
      }
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
      e.printStackTrace();
    }
  }

  private void processRequest(Socket socket) {
    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out);

      InetSocketAddress clientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s 클라이언트 접속함!\n", clientAddress.getHostString());

      out.writeUTF("학급 관리 시스템");

      new LoginListener(memberDao).service(prompt);

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();
    }
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


