package bitcamp.programmers.ex13;

public class Test17 {
  public int solution(int order) {
    int answer = 0;
    String numstr = String.valueOf(order);
    for (int i = 0; i < numstr.length(); i++) {
      char digit = numstr.charAt(i);
      if (digit == '3' || digit == '6' || digit == '9') {
        answer += 1;
      }
    }
    return answer;
  }
}

// 369 게임

class Solution {
  public int solution(int order) {
    int answer = 0;

    String str = order + "";

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '3' || c == '6' || c == '9')
        answer++;
    }

    return answer;
  }
}
