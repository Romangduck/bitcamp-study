package bitcamp.util;

// 소스 코드에서 Calculator 클래스는 bitcamp.util 패지키에 소석된 클래스를 가리킨다.

public class Calculator {

  private int result = 0;

  public int getResult() {
    return this.result;
  }

  public void init(int a) {
    this.result = a;
  }

  public void plus(int a) {
    this.result += a;
  }

  public void minus(int a) {
    this.result -= a;
  }

  public void multiple(int a) {
    this.result *= a;
  }

  public void divide(int a) {
    this.result /= a;
  }
}