package project.myapp.handler;

import project.myapp.vo.Member;
import project.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int userId = 1;
  static int length = 0;
  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();

    m.name = Prompt.inputString("이름? ");
    m.age = Integer.parseInt(Prompt.inputString("나이? "));
    m.gender = inputGender((char) 0);
    m.height = Integer.parseInt(Prompt.inputString("키? "));
    m.weight = Integer.parseInt(Prompt.inputString("몸무게? "));
    m.leftEye = Float.parseFloat(Prompt.inputString("시력(왼쪽)? "));
    m.rightEye = Float.parseFloat(Prompt.inputString("시력(오른쪽)? "));
    m.no = userId++;
    members[length++] = m;
  }

  public static void printMembers() {
    System.out.println("==========================================================");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("==========================================================");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f\n",
          m.no, m.name, m.age, m.gender,
          m.height, m.weight, m.leftEye, m.rightEye);
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.name);
        System.out.printf("나이: %d\n", m.age);
        System.out.printf("성별: %s\n", toGenderString(m.gender));
        return;
      }
    }
    System.out.println("해당 번호의 인원 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)? ", m.name);
        m.name = Prompt.inputString("");
        System.out.printf("나이? ", m.age);
        m.age = Prompt.inputInt("");
        System.out.printf("키?");
        m.height = Prompt.inputInt("");
        System.out.printf("몸무게?", m.weight);
        m.weight = Prompt.inputInt("");
        System.out.printf("왼쪽시력?", m.leftEye);
        m.leftEye = Prompt.inputFloat("");
        System.out.printf("오른쪽 시력", m.rightEye);
        m.rightEye = Prompt.inputFloat("");

        m.gender = inputGender(m.gender);
        return;
      }
    }
    System.out.println("해당 번호의 인원이 없습니다!");
  }

  public static char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label +
          "  1. 남자\n" +
          "  2. 여자\n" +
          "> ");

      switch (menuNo) {
        case "1":
          return MALE;
        case "2":
          return FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 인원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}