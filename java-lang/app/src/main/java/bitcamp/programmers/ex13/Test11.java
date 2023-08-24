package bitcamp.programmers.ex13;

public class Test11 {
  public int solution(int n, int t) {
    return n * (int) Math.pow(2, t);
  }
}

// 세균증식

class solution {
  public int solution(int n, int t) {
    for (int i = 1; i <= t; i++) {
      n *= 2;
    }
    return n;
  }
}