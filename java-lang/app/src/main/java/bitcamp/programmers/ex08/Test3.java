package bitcamp.programmers.ex08;

import java.util.Arrays;

public class Test3 {
  public int solution(int[] array, int height) {
    Arrays.sort(array);
    int answer = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] > height) {
        answer++;
      }
    }

    return answer;
  }
}

// 머쓱이 보다 키큰놈 !