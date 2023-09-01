package bitcamp.project;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("신체검사 관리 시스템");
    System.out.println("----------------------------------");

    // 키보드 스캐너 준비
    Scanner sc = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    int[] age = new int[SIZE];
    int[] height = new int[SIZE];
    int[] weight = new int[SIZE];
    char[] gender = new char[SIZE];
    float[] leftEye = new float[SIZE];
    float[] rightEye = new float[SIZE];

    for (int i = 0; i < 3; i++) {
      System.out.print("번호? ");
      no[i] = sc.nextInt();

      System.out.print("이름? ");
      name[i] = sc.next();

      System.out.print("나이? ");
      age[i] = sc.nextInt();

      System.out.print("키? ");
      height[i] = sc.nextInt();

      System.out.print("몸무게? ");
      weight[i] = sc.nextInt();

      System.out.print("성별(남자:M, 여자:W)? ");
      String str = sc.next();
      gender[i] = str.charAt(0);

      System.out.print("시력(왼쪽, 오른쪽)? ");
      leftEye[i] = sc.nextFloat();
      rightEye[i] = sc.nextFloat();
    }

    System.out.println("---------------------------------------");

    for (int i = 0; i < 3; i++) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("나이: %d\n", age[i]);
      System.out.printf("키: %d\n", height[i]);
      System.out.printf("몸무게: %d\n", weight[i]);
      System.out.printf("성별(남자(M), 여자(W)): %c\n", gender[i]);
      System.out.printf("좌우시력: %.1f,%.1f\n", leftEye[i], rightEye[i]);
    }
    sc.close();
  }
}


// 입력
// 신체검사 관리 시스템
// ----------------------------------
// 번호? 1
// 이름? 홍길동
// 나이? 20
// 키? 182
// 몸무게? 60
// 성별(남자:M, 여자:W)? M
// 시력(왼쪽, 오른쪽)? 1.5 1.0
// 번호? 2
// 이름? 홍길동
// 나이? 21
// 키? 163
// 몸무게? 65
// 성별(남자:M, 여자:W)? M
// 시력(왼쪽, 오른쪽)? 1.0 1.5
// 번호? 3
// 이름? 홍길순
// 나이? 20
// 키? 140
// 몸무게? 50
// 성별(남자:M, 여자:W)? W
// 시력(왼쪽, 오른쪽)? 0.5 0.5


//출력

// ---------------------------------------
// 번호: 1
// 이름: 홍길동
// 나이: 20
// 키: 182
// 몸무게: 60
// 성별(남자(M), 여자(W)): M
// 좌우시력: 1.5,1.0
// 번호: 2
// 이름: 홍길동
// 나이: 21
// 키: 163
// 몸무게: 65
// 성별(남자(M), 여자(W)): M
// 좌우시력: 1.0,1.5
// 번호: 3
// 이름: 홍길순
// 나이: 20
// 키: 140
// 몸무게: 50
// 성별(남자(M), 여자(W)): W
// 좌우시력: 0.5,0.5