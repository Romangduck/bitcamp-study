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

// 1) 클라이언트가 보낸 명령을 데이터이름과 메서드 이름으로 분리한다.

public class ServerApp01 {

  int port;
  ServerSocket serverSocket;

  MemberDao memberDao = new MemberListDao("member.json");
  BoardDao boardDao = new BoardListDao("board.json");
  BoardDao complaintDao = new BoardListDao("complaint.json");

  public ServerApp01(int port) throws Exception {
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

    ServerApp01 app = new ServerApp01(Integer.parseInt(args[0]));
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

      // 데이터 이름과 메서드 이름 알아내기
      String[] values = command.split("/");
      String dataName = values[0];
      String methodName = values[1];
      System.out.printf("%s.%s\n", dataName, methodName);

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
            response.status(ResponseEntity.SUCCESS);
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
            response.status(ResponseEntity.SUCCESS);
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
            response.status(ResponseEntity.SUCCESS);
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


