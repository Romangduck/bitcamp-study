package bitcamp.project;

public class App {
  public static void main(String[] args) {
    System.out.println("신체검사 관리 시스템");
    System.out.println("----------------------------------");

    int no = 100;
    String name = "홍길동";
    int age = 20;
    char gender = 'M';
    int height = 182;
    int weight = 60;
    float leftEye = 1.5f;
    float rightEye = 1.0f;

   
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %d\n", age);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    System.out.printf("키: %d\n", height);
    System.out.printf("몸무게: %d\n", weight);
    System.out.printf("좌우시력: %.1f,%.1f\n", leftEye, rightEye);
  }
}

// 신체검사 관리 시스템
// ----------------------------------
// 번호: 100
// 이름: 홍길동
// 나이: 20
// 성별(남자(M), 여자(W)): M
// 키: 182
// 몸무게: 60
// 좌우시력: 1.5,1.0