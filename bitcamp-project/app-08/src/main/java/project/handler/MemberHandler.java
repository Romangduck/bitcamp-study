package bitcamp.project.handler;

mport bitcamp.project.util.Prompt;

public class MemberHandler {

  static Scanner sc;
  static final int MAX_SIZE = 100;
  static int userId = 1;
  static int length = 0;
  static final char MALE = 'M';
  static final char FEMALE = 'W';
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static int[] age = new int[MAX_SIZE];
  static int[] height = new int[MAX_SIZE];
  static int[] weight = new int[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static float[] leftEye = new float[MAX_SIZE];
  static float[] rightEye = new float[MAX_SIZE];

  static void inputMember() {

    name[length] = prompt("이름? ");
    age[length] = Integer.parseInt(prompt("나이? "));
    height[length] = Integer.parseInt(prompt("키? "));
    weight[length] = Integer.parseInt(prompt("몸무게? "));
    leftEye[length] = Float.parseFloat(prompt("시력(왼쪽)? "));
    rightEye[length] = Float.parseFloat(prompt("시력(오른쪽)? "));

    loop: while (true) {
      String menuNo = prompt("성별:\n" +
      "  1. 남자\n"+
      "  2. 여자\n"+
      "> ");
    
      switch (menuNo) {
        case "1":
          gender[length] = 'M';
          break loop;
        case "2":
          gender[length] = 'W';
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
    no[length] = userId++;
    length++;
  }
  
  static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 성별, 키, 몸무게, 왼쪽 시력, 오른쪽 시력");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %d, %c , %d, %d, %.1f , %.1f\n",
       no[i], name[i], age[i], gender[i], height[i], weight[i], leftEye[i], rightEye[i]);
    }
  }
  public static boolean available(){
    return length < MAX_SIZE;
  }


}



