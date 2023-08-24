package bitcamp.programmers.ex01;

public class Test9 {
  class Solution {
    public int solution(int n) {
      int answer = 0;
      for (int i = 2; i < n; i++) {
        if (n % i == 1) {
          answer = i;
          break;
        }
      }
      return answer;
    }
  }

}

// 나머지가 1인 숫자 찾기