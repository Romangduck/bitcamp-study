package bitcamp.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userID = 1;
    int length = 0;

    int[] no1 = new int[MAX_SIZE];
    String[] name1 = new String[MAX_SIZE];
    String[] email1 = new String[MAX_SIZE];
    String[] password1 = new String[MAX_SIZE];
    char[] gender1 = new char[MAX_SIZE];

    printTitle();

    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(scanner, i, name1, email1, password1, gender1, no1, userID++);

      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    printMembers(length, no1, name1, email1, gender1);

    scanner.close();

  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("---------------------------------");
  }

  static void inputMember(Scanner scanner, int i,
      String[] name1, String[] email1,
      String[] password1, char[] gender1, int[] no1, int userID) {

    System.out.print("이름? ");
    name1[i] = scanner.next();

    System.out.print("이메일? ");

    email1[i] = scanner.next();

    System.out.print("암호? ");

    password1[i] = scanner.next();

    loop: while (true) {
      System.out.println("성별: ");
      System.out.println(" 1. 남자 ");
      System.out.println(" 2. 여자 ");
      System.out.println(" > ");
      String menuNo = scanner.next();
      scanner.nextLine(); // 입력 값을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.
      switch (menuNo) {
        case "1":
          gender1[i] = 'M';
          break;
        case "2":
          gender1[i] = 'W';
          break loop;

        default:
          System.out.println("무효한 번호입니다.");

      }
    }
    no1[i] = userID++;

  }

  static boolean promptContinue(Scanner scanner) {
    System.out.println("계속 하시겠습니까?(Y/n) ");

    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }

    return true;
  }

  static void printMembers(int length, int[] no1, String[] name1, String[] email1, char[] gender1) {
    System.out.println("----------------------------");
    System.out.println("번호 , 이름 , 이메일 , 성별");
    System.out.println("----------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s ,%s ,%c\n", no1[i], name1[i], email1[i], gender1[i]);
    }
  }
}
