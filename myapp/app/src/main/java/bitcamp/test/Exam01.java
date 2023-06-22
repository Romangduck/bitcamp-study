package bitcamp.test;

class A {
  // static int v1;

  // static void m1() {}

  static {
    System.out.println("A클래스의 스태틱 블록 실행!1");
    System.out.println("A클래스의 스태틱 블록 실행!2");
    System.out.println("A클래스의 스태틱 블록 실행!3");
  }
}


public class Exam01 {

  public static void main(String[] args) {
    A obj;
    // A.v1 = 100;
    // A.m1();
    // obj = new A();

    // 레퍼런스 변수를 선언할때는 클래스 로딩X
    // 스태틱필드를 사용하는 시점, 메서드를 호출하려는시점
    // new 명령어를 통해 인스턴스를 만드려는시점
    // 클래스가 로딩됨.
    // *한번만 로딩함
    // 로딩될땐 필드,메서드,블록 순으로 로딩됨
    //

    try {
      Class.forName("bitcamp.test.A");
      // fully=qualified class name,FQN,QName

    } catch (ClassNotFoundException e) {
      System.out.println("클래스 못찾네!");
    }
    // 이외에 Class를 호출할때 예외인 경우도 출력을 해줘야함.
  }

}
