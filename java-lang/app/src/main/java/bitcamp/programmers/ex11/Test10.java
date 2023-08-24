package bitcamp.programmers.ex11;

import java.util.ArrayList;
import java.util.List;

class Test01 {
  public int[] solution(int n) {
    List<Integer> divisors = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        divisors.add(i);
      }
    }

    int[] answer = new int[divisors.size()];
    for (int i = 0; i < divisors.size(); i++) {
      answer[i] = divisors.get(i);
    }

    return answer;
  }
}

// 약수 구하기
