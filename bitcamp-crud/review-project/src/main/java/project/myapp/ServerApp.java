// 52 MyBatis
package project.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
import project.util.SqlSessionFactoryProxy;

public class ServerApp {

  ExecutorService threadPool = Executors.newFixedThreadPool(2);

  SqlSessionFactory sqlSessionFactory;
  MemberDao memberDao;
  BoardDao boardDao;

  int port;


  MenuGroup mainMenu = new MenuGroup("메인");

  public ServerApp(int port) throws Exception {

    this.port = port;
    // 1) mybatis 설정 파일을 읽어들일 도구를 준비한다.
    InputStream mybatisConfigIn =
        Resources.getResourceAsStream("project/myapp/config/mybatis-config.xml");

    // 2) SqlSessionFactory를 만들어줄 빌더 객체 준비
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    // 3) 빌더 객체를 통해 SqlSessionFactory를 생성
    sqlSessionFactory = new SqlSessionFactoryProxy(builder.build(mybatisConfigIn));

    this.memberDao = new MySQLMemberDao(sqlSessionFactory);
    this.boardDao = new MySQLBoardDao(sqlSessionFactory);


    prepareMenu();
  }

  public void close() throws Exception {

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

      out.writeUTF("문화 생활 리뷰");

      new LoginListener(memberDao).service(prompt);

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();

    } finally {
      ((SqlSessionFactoryProxy) sqlSessionFactory).clean();
    }
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원 정보");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao, sqlSessionFactory)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao, sqlSessionFactory)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao, sqlSessionFactory)));
    mainMenu.add(memberMenu);

    MenuGroup movieMenu = new MenuGroup("영화 리뷰");
    movieMenu.add(new Menu("등록", new BoardAddListener(1, boardDao, sqlSessionFactory)));
    movieMenu.add(new Menu("목록", new BoardListListener(1, boardDao)));
    movieMenu.add(new Menu("조회", new BoardDetailListener(1, boardDao, sqlSessionFactory)));
    movieMenu.add(new Menu("변경", new BoardUpdateListener(1, boardDao, sqlSessionFactory)));
    movieMenu.add(new Menu("삭제", new BoardDeleteListener(1, boardDao, sqlSessionFactory)));
    mainMenu.add(movieMenu);

    MenuGroup webtoonMenu = new MenuGroup("웹툰 리뷰");
    webtoonMenu.add(new Menu("등록", new BoardAddListener(2, boardDao, sqlSessionFactory)));
    webtoonMenu.add(new Menu("목록", new BoardListListener(2, boardDao)));
    webtoonMenu.add(new Menu("조회", new BoardDetailListener(2, boardDao, sqlSessionFactory)));
    webtoonMenu.add(new Menu("변경", new BoardUpdateListener(2, boardDao, sqlSessionFactory)));
    webtoonMenu.add(new Menu("삭제", new BoardDeleteListener(2, boardDao, sqlSessionFactory)));
    mainMenu.add(webtoonMenu);

    MenuGroup webnovelMenu = new MenuGroup("웹_소설 리뷰");
    webnovelMenu.add(new Menu("등록", new BoardAddListener(3, boardDao, sqlSessionFactory)));
    webnovelMenu.add(new Menu("목록", new BoardListListener(3, boardDao)));
    webnovelMenu.add(new Menu("조회", new BoardDetailListener(3, boardDao, sqlSessionFactory)));
    webnovelMenu.add(new Menu("변경", new BoardUpdateListener(3, boardDao, sqlSessionFactory)));
    webnovelMenu.add(new Menu("삭제", new BoardDeleteListener(3, boardDao, sqlSessionFactory)));
    mainMenu.add(webnovelMenu);

    MenuGroup animeMenu = new MenuGroup("애니메이션 리뷰");
    animeMenu.add(new Menu("등록", new BoardAddListener(4, boardDao, sqlSessionFactory)));
    animeMenu.add(new Menu("목록", new BoardListListener(4, boardDao)));
    animeMenu.add(new Menu("조회", new BoardDetailListener(4, boardDao, sqlSessionFactory)));
    animeMenu.add(new Menu("변경", new BoardUpdateListener(4, boardDao, sqlSessionFactory)));
    animeMenu.add(new Menu("삭제", new BoardDeleteListener(4, boardDao, sqlSessionFactory)));
    mainMenu.add(animeMenu);

    // Menu helloMenu = new Menu("안녕!");
    // helloMenu.addActionListener(new HeaderListener());
    // helloMenu.addActionListener(new HelloLis tener());
    // helloMenu.addActionListener(new FooterListener());
    // mainMenu.add(helloMenu);
  }
}


