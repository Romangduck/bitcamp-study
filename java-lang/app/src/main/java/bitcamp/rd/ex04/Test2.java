package bitcamp.rd.ex04;

public class Test2 {
  public int solution(int number, int n, int m) {
    if (number % n == 0 && number % m == 0) {
      return 1;
    } else {
      return 0;
    }
  }
}