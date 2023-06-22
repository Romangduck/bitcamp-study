package bitcamp.test;

class A {
  int v1;
  int v2;
  {
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
  }


  public A() {
    System.out.println("444");
  }

  public A(int a) {
    System.out.println("555");
  }

  public A(int a, int b) {
    System.out.println("666");
  }

}


// 모든생성자에 공통으로 넣고싶다면 인스턴스 블록에 넣어주면됨
// 인스턴스 블록은 static이 붙어있지않은것들.
// 인스턴스 블록은 가능한 가장위쪽으로, 그리고 블록을 너무 많이
// 나누지말자


public class Exam10 {

  public static void main(String[] args) {

    new A();
    new A();
    new A();
  }
}
