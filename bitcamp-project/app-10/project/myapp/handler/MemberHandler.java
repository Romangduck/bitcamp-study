package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.Prompt;

public class MemberHandler implements Handler {

  private static final int MAX_SIZE = 100;

  private Prompt prompt;
  private Member[] members = new Member[MAX_SIZE];
  private int length;
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

  public void inputMember() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(this.prompt.inputString("이름? "));
    m.setAge(Integer.parseInt(this.prompt.inputString("나이? ")));
    m.setGender(inputGender((char) 0));
    m.setHeight(Integer.parseInt(this.prompt.inputString("키? ")));
    m.setWeight(Integer.parseInt(this.prompt.inputString("몸무게? ")));
    m.setLeftEye(Float.parseFloat(this.prompt.inputString("시력(왼쪽)? ")));
    m.setRightEye(Float.parseFloat(this.prompt.inputString("시력(오른쪽)? ")));

    this.members[this.length++] = m;
  }

  public void printMembers() {
    System.out.println("==========================================================");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("==========================================================");

    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f\n", m.getNo(), m.getName(),
          m.getAge(), m.getGender(), m.getHeight(), m.getWeight(), m.getLeftEye(), m.getRightEye());
    }
  }

  public void viewMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("나이: %d\n", m.getAge());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        System.out.printf("키: %d\n", m.getHeight());
        System.out.printf("몸무게 : %d\n", m.getWeight());
        System.out.printf("왼쪽 시력: %.1f\n", m.getLeftEye());
        System.out.printf("오른쪽 시력: %.1f\n", m.getRightEye());

        return;
      }
    }
    System.out.println("해당 번호의 인원 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public void updateMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {

        m.setName(this.prompt.inputString("이름(%s)?", m.getName()));

        m.setAge(this.prompt.inputInt("나이? ", m.getAge()));
        m.setHeight(this.prompt.inputInt("키? ", m.getHeight()));
        m.setWeight(this.prompt.inputInt("몸무게? ", m.getWeight()));
        m.setLeftEye(this.prompt.inputFloat("왼쪽 시력? ", m.getLeftEye()));
        m.setRightEye(this.prompt.inputFloat("오른쪽 시력? ", m.getRightEye()));

        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 인원이 없습니다!");
  }

  public char inputGender(char gender) {
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

  public void deleteMember() {
    int deletedIndex = indexOf(this.prompt.inputInt("번호? "));
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 인원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }

    this.members[--this.length] = null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
