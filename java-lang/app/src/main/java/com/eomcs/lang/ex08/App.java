package bitcamp.myapp;

import java.util.Scanner;

public class App {
  static Scanner scanner = new Scanner(System.in);

  static final int MAX_SIZE = 100;
  static int[] no1 = new int[MAX_SIZE];
  static String[] name1 = new String[MAX_SIZE];
  static String[] email1 = new String[MAX_SIZE];
  static String[] password1 = new String[MAX_SIZE];
  static char[] gender1 = new char[MAX_SIZE];
  static int userID = 1;
  static int length = 0;
  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void main(String[] args) {

    printTitle();

    while (length < MAX_SIZE) {
      inputMember();

      length++;
      if (!promptContinue()) {
        break;
      }
    }

    printMembers();

    scanner.close();

  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("---------------------------------");
  }

  static void inputMember() {

    name1[length] = prompt("이름?");
    email1[length] = prompt("이메일?");
    password1[length] = prompt("암호?");

    loop: while (true) {
      String menuNo = prompt("성별:\n" +
          "1. 남자\n" +
          "2. 여자\n" +
          ">");

      scanner.nextLine(); // 입력 값을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.
      switch (menuNo) {
        case "1":
          gender1[length] = MALE;
          break;
        case "2":
          gender1[length] = FEMALE;
          break loop;

        default:
          System.out.println("무효한 번호입니다.");

      }
    }
    no1[length] = userID++;

  }

  static boolean promptContinue() {
    System.out.println("계속 하시겠습니까?(Y/n) ");

    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }

    return true;
  }

  static void printMembers() {
    System.out.println("----------------------------");
    System.out.println("번호 , 이름 , 이메일 , 성별");
    System.out.println("----------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s ,%s ,%c\n", no1[i], name1[i], email1[i], gender1[i]);
    }
  }

  static String prompt(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }
}
