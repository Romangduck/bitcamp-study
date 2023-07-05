package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.BoardNetworkDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.MemberNetworkDao;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.MenuGroup;

public class ClientApp {
  Socket socket;
  DataOutputStream out;
  DataInputStream in;

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {
    this.socket = new Socket(ip, port);
    this.out = new DataOutputStream(socket.getOutputStream());
    this.in = new DataInputStream(socket.getInputStream());

    this.memberDao = new MemberNetworkDao("member", in, out);
    this.boardDao = new BoardNetworkDao("board", in, out);
    this.readingDao = new BoardNetworkDao("reading", in, out);

    prepareMenu();
  }

  public void close() throws Exception {
    prompt.close();
    out.close();
    in.close();
    socket.close();
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("실행 예) java . . . bitcamp.myapp.ClientApp 서버주소 포트번호");
      return;
    }
    ClientApp app = new ClientApp(args[0], Integer.parseInt(args[1]));
    app.execute();
    app.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {

    printTitle();
    mainMenu.execute(prompt);

  }
}
