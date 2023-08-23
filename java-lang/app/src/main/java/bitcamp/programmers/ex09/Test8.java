package bitcamp.rd.ex09;

public class Test8 {
  public int solution(int n) {
    int answer = 0;

    for (int i = 1; i < n + 1; i++) {
      if (n % i == 0) {
        answer++;
      }
    }
    return answer;
  }
}

// 순서쌍의 개수