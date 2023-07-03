package project.myapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.Menu;
import project.util.MenuGroup;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> readingList = new LinkedList<>();

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
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {
    loadMember();
    loadBoard("board.data", boardList);
    loadBoard("reading.data", readingList);
  }

  private void saveData() {
    saveMember();
    saveBoard("board.data", boardList);
    saveBoard("reading.data", readingList);
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
    readingMenu.add(new Menu("등록", new BoardAddListener(readingList)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingList)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }

  private void loadMember() {
    try {
      FileInputStream in = new FileInputStream("member.data");
      int size = in.read() << 8;
      size |= in.read();

      byte[] buf = new byte[1000];

      for (int i = 0; i < size; i++) {
        Member member = new Member();
        member.setNo(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        int length = in.read() << 8 | in.read();
        in.read(buf, 0, length);
        member.setName(new String(buf, 0, length, "UTF-8"));

        Member age = new Member();
        age.setAge(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        Member height = new Member();
        height.setHeight(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        Member weight = new Member();
        weight.setWeight(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        Member leftEye = new Member();
        leftEye.setLeftEye(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        Member rightEye = new Member();
        rightEye.setRightEye(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        member.setGender((char) (in.read() << 8 | in.read()));

        memberList.add(member);
      }

      // 데이터를 로딩한 이후에 추가할 회원의 번호를 설정한다.
      Member.userId = memberList.get(memberList.size() - 1).getNo() + 1;

      in.close();

    } catch (Exception e) {
      System.out.println("회원 정보를 읽는 중 오류 발생!");
    }
  }

  private void loadBoard(String filename, List<Board> list) {
    try {
      FileInputStream in = new FileInputStream(filename);
      int size = in.read() << 8;
      size |= in.read();

      byte[] buf = new byte[1000];

      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setNo(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        int length = in.read() << 8 | in.read();
        in.read(buf, 0, length);
        board.setTitle(new String(buf, 0, length, "UTF-8"));

        length = in.read() << 8 | in.read();
        in.read(buf, 0, length);
        board.setContent(new String(buf, 0, length, "UTF-8"));

        length = in.read() << 8 | in.read();
        in.read(buf, 0, length);
        board.setWriter(new String(buf, 0, length, "UTF-8"));

        length = in.read() << 8 | in.read();
        in.read(buf, 0, length);
        board.setPassword(new String(buf, 0, length, "UTF-8"));

        board.setViewCount(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        board.setCreatedDate((long) in.read() << 56 | (long) in.read() << 48
            | (long) in.read() << 40 | (long) in.read() << 32 | (long) in.read() << 24
            | (long) in.read() << 16 | (long) in.read() << 8 | in.read());

        list.add(board);
      }

      Board.boardNo = Math.max(Board.boardNo, list.get(list.size() - 1).getNo() + 1);

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveMember() {
    try {
      FileOutputStream out = new FileOutputStream("member.data");

      // 저장할 데이터의 개수를 먼저 출력한다.
      int size = memberList.size();
      out.write(size >> 8);
      out.write(size);

      for (Member member : memberList) {
        int no = member.getNo();
        out.write(no >> 24);
        out.write(no >> 16);
        out.write(no >> 8);
        out.write(no);

        byte[] bytes = member.getName().getBytes("UTF-8");
        // 출력할 바이트의 개수를 2바이트로 표시한다.
        out.write(bytes.length >> 8);
        out.write(bytes.length);

        // 문자열의 바이트를 출력한다.
        out.write(bytes);

        int age = member.getAge();
        out.write(age >> 24);
        out.write(age >> 16);
        out.write(age >> 8);
        out.write(age);

        int height = member.getHeight();
        out.write(height >> 24);
        out.write(height >> 16);
        out.write(height >> 8);
        out.write(height);

        int weight = member.getWeight();
        out.write(weight >> 24);
        out.write(weight >> 16);
        out.write(weight >> 8);
        out.write(weight);

        float leftEye = member.getLeftEye();
        out.write((int) leftEye >> 24);
        out.write((int) leftEye >> 16);
        out.write((int) leftEye >> 8);
        out.write((int) leftEye);

        float rightEye = member.getRightEye();
        out.write((int) rightEye >> 24);
        out.write((int) rightEye >> 16);
        out.write((int) rightEye >> 8);
        out.write((int) rightEye);

        char gender = member.getGender();
        out.write(gender >> 8);
        out.write(gender);
      }
      out.close();

    } catch (Exception e) {
      System.out.println("회원 정보를 저장하는 중 오류 발생!");
    }
  }

  private void saveBoard(String filename, List<Board> list) {
    try {
      FileOutputStream out = new FileOutputStream(filename);

      // 저장할 데이터의 개수를 먼저 출력한다.
      int size = list.size();
      out.write(size >> 8);
      out.write(size);

      for (Board board : list) {
        int no = board.getNo();
        out.write(no >> 24);
        out.write(no >> 16);
        out.write(no >> 8);
        out.write(no);

        byte[] bytes = board.getTitle().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);


        bytes = board.getContent().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        bytes = board.getWriter().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        bytes = board.getPassword().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        int viewCount = board.getViewCount();
        out.write(viewCount >> 24);
        out.write(viewCount >> 16);
        out.write(viewCount >> 8);
        out.write(viewCount);

        long createdDate = board.getCreatedDate();
        out.write((int) (createdDate >> 56));
        out.write((int) (createdDate >> 48));
        out.write((int) (createdDate >> 40));
        out.write((int) (createdDate >> 32));
        out.write((int) (createdDate >> 24));
        out.write((int) (createdDate >> 16));
        out.write((int) (createdDate >> 8));
        out.write((int) createdDate);
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
