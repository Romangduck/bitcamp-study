package bitcamp.rd.ex13;

class Test15 {
  public long solution(int a, int b) {
    long difference = Math.abs((long) a - (long) b) + 1;
    long answer = (a + b) * difference / 2;
    return answer;
  }
}

// 두 정수 사이의 합

class Solution {
  public long solution(int a, int b) {
    long answer = 0;

    if (a < b) {
      for (int i = a; i <= b; i++) {
        answer += i;
      }
    } else {
      for (int i = b; i <= a; i++) {
        answer += i;
      }
    }
    return answer;
  }
}
