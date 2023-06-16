package bitcamp.rd.ex06;

public class Test4 {
  public int solution(int n, int k) {
    int answer = 0;
    int drink = 0;

    answer += n * 12000;
    answer += k * 2000;

    if (n >= 10) {
      drink = n / 10;
    }
    answer -= drink * 2000;
    return answer;
  }
}

// 양꼬치 서비스
