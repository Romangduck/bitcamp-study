package project.handler;

import project.util.Prompt;

public class MemberHandler {

  public static Scanner sc;
  public static final int MAX_SIZE = 100;
  public static int userId = 1;
  public static int length = 0;
  public static final char MALE = 'M';
  public static final char FEMALE = 'W';
  public static int[] no = new int[MAX_SIZE];
  public static String[] name = new String[MAX_SIZE];
  public static int[] age = new int[MAX_SIZE];
  public static int[] height = new int[MAX_SIZE];
  public static int[] weight = new int[MAX_SIZE];
  public static char[] gender = new char[MAX_SIZE];
  public static float[] leftEye = new float[MAX_SIZE];
  public static float[] rightEye = new float[MAX_SIZE];

  public static void inputMember() {

    name[length] = Prompt.inputString("이름? ");
    age[length] = Integer.parseInt(Prompt.inputString("나이? "));
    height[length] = Integer.parseInt(Prompt.inputString("키? "));
    weight[length] = Integer.parseInt(Prompt.inputString("몸무게? "));
    leftEye[length] = Float.parseFloat(Prompt.inputString("시력(왼쪽)? "));
    rightEye[length] = Float.parseFloat(Prompt.inputString("시력(오른쪽)? "));

    loop: while (true) {
      String menuNo = Prompt.inputString("성별:\n" +
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
  
  public static void printMembers() {
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



