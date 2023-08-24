package bitcamp.programmers.ex06;

public class Test1 {
  public int solution(int angle) {
    if (angle > 0 && angle < 90) {
      return 1;
    } else if (angle == 90) {
      return 2;
    } else if (angle > 90 && angle < 180) {
      return 3;
    } else {
      return 4;
    }
  }
}

// 각도기

// class Solution {
// public int solution(int angle) {
// return angle == 180 ? 4 : angle < 90 ? 1 : angle == 90 ? 2 : angle > 90 ? 3 :
// 0;
// }
// }