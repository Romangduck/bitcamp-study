package bitcamp.project;


import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // 키보드 스캐너 준비
    Scanner sc = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    int[] age = new int[MAX_SIZE];
    int[] height = new int[MAX_SIZE];
    int[] weight = new int[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];
    float[] leftEye = new float[MAX_SIZE];
    float[] rightEye = new float[MAX_SIZE];

    printTitle();

    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(sc, i, name, age, height, weight, gender, no, userId++,
      leftEye,rightEye);

      
      length++;
      if (!promptContinue(sc)) {
        break;
      }
    }
    printMembers(length, no, name, age, height , weight , gender , leftEye , rightEye);

    sc.close();
  }
    static void printTitle() {
      System.out.println("신체검사 관리 시스템");
      System.out.println("----------------------------------");
    }

    static void inputMember(Scanner sc,int i,String[] name, int[] age,
     int[] height,int[] weight,char[] gender,
     int[] no, int userId,float[] leftEye, float[] rightEye) {


      System.out.print("이름? ");
      name[i] = sc.next();

      System.out.print("나이? ");
      age[i] = sc.nextInt();

      System.out.print("키? ");
      height[i] = sc.nextInt();

      System.out.print("몸무게? ");
      weight[i] = sc.nextInt();

      System.out.print("시력(왼쪽, 오른쪽)? ");
      leftEye[i] = sc.nextFloat();
      rightEye[i] = sc.nextFloat();

      loop: while (true) {
        System.out.println("성별: ");
        System.out.println("  1. 남자");
        System.out.println("  2. 여자");
        System.out.print("> ");
        String menuNo = sc.nextLine();

        switch (menuNo) {
          case "1":
            gender[i] = 'M';
            break loop;
          case "2":
            gender[i] = 'W';
            break loop;
          default:
            System.out.println("무효한 번호입니다.");
        }
      }

      no[i] = userId;
    }

    static boolean promptContinue(Scanner sc) {
      System.out.print("계속 하시겠습니까?(Y/n) ");
      String response = sc.nextLine();
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        return false;
      }
      return true;
    }
    static void printMembers(int length, int[] no,
     String[] name, int[] age,int[] height,int[] weight,
      char[] gender , float[] leftEye, float[] rightEye) {
    System.out.println("---------------------------------------");

    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f",
       no[i], name[i], age[i], gender[i], height[i], weight[i], leftEye[i], rightEye[i]);
    }
  }
}

