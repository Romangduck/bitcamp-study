package bitcamp.rd.ex06;

public class Test2 {
  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        answer += i;
      }
    }
    return answer;
  }
}

// n 까지 짝수의 합