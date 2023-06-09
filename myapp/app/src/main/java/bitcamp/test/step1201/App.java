package bitcamp.test.step1201;

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
// 1201) 변수의 접근을 제어하기 : private , public   // 57 , 23,24  //

public class App {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    private int sum;
    private float aver;

    void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }

    Score(String name, int kor, int eng, int math) {

      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.compute();

    }

  }

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

    // 이렇게 개발자가 직접 인스턴스 필드에 접근하는 것을 막을 수 없다.
    // -> 출력값은 300이 되어야하지만 600으로 사용자가 지정을하였기에
    // 600으로 출력 된다.
    scores[0].sum = 600;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  // 팩토리 메서드 ( 객체 생성 과정이 번거롭거나 복잡할때,
  // 메소드에게 값을 던져 메소드가 인스턴스를 리턴하게하는것)

  static void printScore(Score s) {
    System.out.printf("%s: 합계=%d, 평균=%.1f\n",
        s.name, s.sum, s.aver);
  }

}