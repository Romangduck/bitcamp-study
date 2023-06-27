package bitcamp.Test;

public class Test {

  public static void main(String[] args) {


    System.out.println(factorial(5, 100));
  }



  static int factorial(int value, long value2) {

    if (value == 1) {
      return 1;
    }
    System.out.println(value);
    return factorial(value - 1, value2 + 1) * value;
  }
}
// 로컬변수는 JVM스택에서 메서드 호출이 중단될때 사라지는데
// 종료지점을 지정하지 않는다면 StackOverFlow(공간이 최대가되며 중단됨)
