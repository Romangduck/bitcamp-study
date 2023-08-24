package bitcamp.programmers.ex07;

public class Test10 {
  public int solution(int n) {
    int pizza = 0;
    int gcd = 0;

    for (int i = 1; i <= n; i++) {
      if (6 % i == 0 && n % i == 0) {
        gcd = i;
      }
    }
    pizza = n / gcd;
    return pizza;
  }
}

// *8 i % 6 으로하면 0.16~이 되기때문에 6 % i
// gcd 라는 변수 -> 최소공배수를 정의하는