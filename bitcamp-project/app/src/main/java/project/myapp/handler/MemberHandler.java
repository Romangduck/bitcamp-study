package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.ArrayList;
import project.util.Prompt;

public class MemberHandler implements Handler {


  private ArrayList list = new ArrayList();
  private Prompt prompt;
  private String title;

  public MemberHandler(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("%s> ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputMember();
      } else if (menuNo.equals("2")) {
        this.printMembers();
      } else if (menuNo.equals("3")) {
        this.viewMember();
      } else if (menuNo.equals("4")) {
        this.updateMember();
      } else if (menuNo.equals("5")) {
        this.deleteMember();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  private static void printMenu() {
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 메인");
  }

  private void inputMember() {

    Member m = new Member();
    m.setName(this.prompt.inputString("이름? "));
    m.setAge(Integer.parseInt(this.prompt.inputString("나이? ")));
    m.setGender(inputGender((char) 0));
    m.setHeight(Integer.parseInt(this.prompt.inputString("키? ")));
    m.setWeight(Integer.parseInt(this.prompt.inputString("몸무게? ")));
    m.setLeftEye(Float.parseFloat(this.prompt.inputString("시력(왼쪽)? ")));
    m.setRightEye(Float.parseFloat(this.prompt.inputString("시력(오른쪽)? ")));

    if (!list.add(m)) {
      System.out.println("입력 실패입니다!");
    }
  }

  private void printMembers() {
    System.out.println("==========================================================");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("==========================================================");

    Object[] arr = list.list();
    for (Object obj : arr) {
      Member m = (Member) obj;
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f\n", m.getNo(), m.getName(),
          m.getAge(), m.getGender(), m.getHeight(), m.getWeight(), m.getLeftEye(), m.getRightEye());
    }
  }

  private void viewMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    Member m = (Member) this.list.get(new Member(memberNo));
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("나이: %d\n", m.getAge());
    System.out.printf("성별: %s\n", toGenderString(m.getGender()));
    System.out.printf("키: %d\n", m.getHeight());
    System.out.printf("몸무게 : %d\n", m.getWeight());
    System.out.printf("왼쪽 시력: %.1f\n", m.getLeftEye());
    System.out.printf("오른쪽 시력: %.1f\n", m.getRightEye());


  }



  private static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  private void updateMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    Member m = (Member) this.list.get(new Member(memberNo));
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    m.setName(this.prompt.inputString("이름(%s)?", m.getName()));

    m.setAge(this.prompt.inputInt("나이? ", m.getAge()));
    m.setHeight(this.prompt.inputInt("키? ", m.getHeight()));
    m.setWeight(this.prompt.inputInt("몸무게? ", m.getWeight()));
    m.setLeftEye(this.prompt.inputFloat("왼쪽 시력? ", m.getLeftEye()));
    m.setRightEye(this.prompt.inputFloat("오른쪽 시력? ", m.getRightEye()));

    m.setGender(inputGender(m.getGender()));
  }



  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = this.prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private void deleteMember() {

    if (!list.delete(new Member(this.prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }
}

