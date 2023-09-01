package bitcamp.project;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("신체검사 관리 시스템");
    System.out.println("----------------------------------");

    //키보드 스캐너 준비
    Scanner sc = new Scanner(System.in);

    System.out.print("번호? ");
    int no = sc.nextInt();

    System.out.print("이름? ");
    String name = sc.next();

    System.out.print("나이? ");
    int age = sc.nextInt();

    System.out.print("성별(남자:M, 여자:W)? ");
    String str = sc.next();
    char gender = str.charAt(0);

    System.out.print("키? ");
    int height = sc.nextInt();


    System.out.print("몸무게? ");
    int weight = sc.nextInt();

    System.out.print("시력(왼쪽, 오른쪽)? ");
    float leftEye = sc.nextFloat();
    float rightEye = sc.nextFloat();

  
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %d\n", age);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    System.out.printf("키: %d\n", height);
    System.out.printf("몸무게: %d\n", weight);
    System.out.printf("좌우시력: %.1f,%.1f\n", leftEye, rightEye);

    sc.close();
  }
}



// 입력

// 신체검사 관리 시스템
// ----------------------------------
// 번호? 100
// 이름? 홍길동
// 나이? 20
// 성별(남자:M, 여자:W)? M
// 키? 182
// 몸무게? 60
// 시력(왼쪽, 오른쪽)? 1.5 1.0

// 출력
// 번호: 100
// 이름: 홍길동
// 나이: 20
// 성별(남자(M), 여자(W)): M
// 키: 182
// 몸무게: 60
// 좌우시력: 1.5,1.0