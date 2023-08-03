package bitcamp.myapp;

<<<<<<< HEAD
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.util.ApplicationContext;
import bitcamp.util.DispatcherListener;
import bitcamp.util.SqlSessionFactoryProxy;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
=======
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.config.AppConfig;
import bitcamp.util.ApplicationContext;
import bitcamp.util.DispatcherServlet;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.SqlSessionFactoryProxy;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.NettyOutbound;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32

public class ServerApp {

  ApplicationContext iocContainer;
<<<<<<< HEAD
  DispatcherListener facadeListener;
=======
  DispatcherServlet dispatcherServlet;
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32

  int port;

  public ServerApp(int port) throws Exception {
    this.port = port;
<<<<<<< HEAD
    //    iocContainer = new ApplicationContext(AppConfig.class);
    //    facadeListener = new DispatcherListener(iocContainer);
=======
    iocContainer = new ApplicationContext(AppConfig.class);
    dispatcherServlet = new DispatcherServlet(iocContainer);
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32
  }

  public void close() throws Exception {

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp(8888);
    app.execute();
    app.close();
  }

  public void execute() throws Exception {
<<<<<<< HEAD
    Path file = Paths.get(ServerApp.class.getResource("/static/index.html").toURI());
    DisposableServer server = HttpServer
        .create()
        .port(8888)
        .route(routes -> routes // 클라이언트 요청을 처리할 객체를 등록한다.
            .get("/hello", (request, response) -> response.sendString(Mono.just("Hello, world!")))
            .get("/board/list", (request, response) -> response.sendString(Mono.just("게시글 목록")))
            .get("/board/add", (request, response) -> response.sendString(Mono.just("게시글 등록")))
            .get("/board/detail", (request, response) -> response.sendString(Mono.just("게시글 조회")))
            .file("/index.html", file)
            )
        .bindNow();
=======
    DisposableServer server = HttpServer.create().port(8888)
        .handle((request, response) -> processRequest(request, response)).bindNow();
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32
    System.out.println("서버 실행됨!");

    server.onDispose().block();
    System.out.println("서버 종료됨!");
  }

<<<<<<< HEAD
  private void processRequest(Socket socket) {
    try {
=======
  private NettyOutbound processRequest(HttpServerRequest request, HttpServerResponse response) {
    HttpServletRequest request2 = new HttpServletRequest(request);
    HttpServletResponse response2 = new HttpServletResponse(response);
    try {
      dispatcherServlet.service(request2, response2);

      // HTTP 응답 프로토콜의 헤더 설정
      response.addHeader("Content-Type", response2.getContentType());

      // 서블릿이 출력한 문자열을 버퍼에서 꺼내 HTTP 프로토콜에 맞춰 응답한다.
      return response.sendString(Mono.just(response2.getContent()));
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32

    } catch (Exception e) {
      e.printStackTrace();
      return response.sendString(Mono.just(response2.getContent()));

    } finally {
      SqlSessionFactoryProxy sqlSessionFactoryProxy =
          (SqlSessionFactoryProxy) iocContainer.getBean(SqlSessionFactory.class);
      sqlSessionFactoryProxy.clean();
    }
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32
