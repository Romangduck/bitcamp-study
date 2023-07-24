// 39
package project.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import project.myapp.dao.BoardDao;
import project.myapp.dao.BoardListDao;
import project.myapp.dao.MemberDao;
import project.myapp.dao.MemberListDao;
import project.myapp.vo.Board;
import project.myapp.vo.Member;
import project.net.RequestEntity;
import project.net.ResponseEntity;

public class ServerApp {

  int port;
  ServerSocket serverSocket;

  MemberDao memberDao = new MemberListDao("member.json");
  BoardDao boardDao = new BoardListDao("board.json");
  BoardDao complaintDao = new BoardListDao("complaint.json");


  public ServerApp(int port) throws Exception {
    this.port = port;
  }

  public void close() throws Exception {
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("실행 예) java ... bitcamp.myapp.ServerApp 포트번호");
      return;
    }

    ServerApp app = new ServerApp(Integer.parseInt(args[0]));
    app.execute();
    app.close();
  }

  public void execute() throws Exception {
    System.out.println("[MyList 서버 애플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");

    Socket socket = serverSocket.accept();
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) {
      RequestEntity request = RequestEntity.fromJson(in.readUTF());

      String command = request.getCommand();
      System.out.println(command);

      if (command.equals("quit")) {
        break;
      }

      ResponseEntity response = new ResponseEntity();

      switch (command) {
        case "board/list":
          response.status(ResponseEntity.SUCCESS).result(boardDao.list());
          break;
        case "board/insert":
          boardDao.insert(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS);
          break;
        case "board/findBy":
          Board board = boardDao.findBy(request.getObject(Integer.class));
          if (board == null) {
            response.status(ResponseEntity.FAILURE).result("해당 번호의 게시글이 없습니다!");
          } else {
            response.status(ResponseEntity.SUCCESS).result(board);
          }
          break;
        case "board/update":
          int value = boardDao.update(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "board/delete":
          value = boardDao.delete(request.getObject(Integer.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "member/list":
          response.status(ResponseEntity.SUCCESS).result(memberDao.list());
          break;
        case "member/insert":
          memberDao.insert(request.getObject(Member.class));
          response.status(ResponseEntity.SUCCESS);
          break;
        case "member/findBy":
          Member member = memberDao.findBy(request.getObject(Integer.class));
          if (member == null) {
            response.status(ResponseEntity.FAILURE).result("해당 번호의 회원이 없습니다!");
          } else {
            response.status(ResponseEntity.SUCCESS).result(member);
          }
          break;
        case "member/update":
          value = memberDao.update(request.getObject(Member.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "member/delete":
          value = memberDao.delete(request.getObject(Integer.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "complaint/list":
          response.status(ResponseEntity.SUCCESS).result(boardDao.list());
          break;
        case "complaint/insert":
          boardDao.insert(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS);
          break;
        case "complaint/findBy":
          board = boardDao.findBy(request.getObject(Integer.class));
          if (board == null) {
            response.status(ResponseEntity.FAILURE).result("해당 번호의 게시글이 없습니다!");
          } else {
            response.status(ResponseEntity.SUCCESS).result(board);
          }
          break;
        case "complaint/update":
          value = boardDao.update(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "complaint/delete":
          value = boardDao.delete(request.getObject(Integer.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        default:
          response.status(ResponseEntity.ERROR).result("해당 명령을 지원하지 않습니다!");
      }

      out.writeUTF(response.toJson());
    }

    in.close();
    out.close();
    socket.close();
  }
}


