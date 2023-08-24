package bitcamp.programmers.ex01;

public class Test7 {
  public int solution(int[] box, int n) {
    int answer = 0;
    int a = box[0] % n;
    int b = box[1] % n;
    int c = box[2] % n;
    answer = (box[0] / n - a / n) * (box[1] / n - b / n) * (box[2] / n - c / n);

    return answer;
  }
}

// 주사위의 개수

class Solution {
  public int solution(int[] box, int n) {
    int answer = 1;

    answer *= box[0] / n;
    answer *= box[1] / n;
    answer *= box[2] / n;

    return answer;
  }
}