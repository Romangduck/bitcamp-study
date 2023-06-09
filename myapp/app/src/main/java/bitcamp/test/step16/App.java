package bitcamp.test.step16;

import bitcamp.test.step16.vo.Score;

// 1) 낱개의 변수 사용
// 2) 낱개의 변수 재사용
// 3) 배열 사용
// 4) 클래스를 이용하여 데이터 타입 정의(중첩 클래스, 로컬 클래스)
// 5) 출력 기능을 별도의 메서드로 분리(중첩 클래스; 스태틱 중첩 클래스)
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴 : Information Expert , 정보를 갖고있는 클래스가 그 정보를 다룬다.
// 8) 인스턴스 메소드 도입
// 9) 객체 생성이 번거롭고 복잡한 경우 메서드로 분리하는 것이 낫다. (디자인 패턴 , 팩토리 메서드)
// 10) GRASP 패턴 : Information Expert // 29 //
// 11) 생성자 도입 : 인스턴스 변수를 보다 쉽게 초기화시키기 //30,52//
// 12) 클래스를 유지보수하기 쉽게 별도 소스 파일로 분리
// 13) 클래스를 유지보수하기 쉽게 패키지로 분리 : import, public
// 14) 외부접근 차단과 값 꺼내기 : private , getter
// 15) 프로그램의 일관성을 위해 보통 다른 필드에 대해서도 getter를 만들고 사용한다.
// 16) 필드의 직접 접근을 막고 setter를 정의하는 이유

public class App {

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    // new Score(문자열 , int, int ,int );
    // => Score 설계도에 따라 인스턴스를 생성하라.
    // => 생성한 후 String, int , int , int 파라미터 값을 받는 생성자를 호출하라.
    // => 이렇게 초기화시킨 인스턴스의 주소를 리턴하라.
    scores[length++] = new Score("홍길동", 100, 100, 100);
    scores[length++] = new Score("유관순", 90, 90, 90);
    scores[length++] = new Score("임꺽정", 80, 80, 80);

    // 합계와 평균 계산이 끝난 후에 국어 점수를 변경하다면
    scores[0].kor = 70;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  // 팩토리 메서드 ( 객체 생성 과정이 번거롭거나 복잡할때,
  // 메소드에게 값을 던져 메소드가 인스턴스를 리턴하게하는것)

  static void printScore(Score s) {
    System.out.printf("%s: 국어=%d, 영어=%d,수학=%d, 합계=%d, 평균=%.1f\n",
        s.getName(), s.kor, s.eng, s.math, s.getSum(), s.getAver());
  }

}