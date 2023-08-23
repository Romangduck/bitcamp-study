package bitcamp.rd.ex11;

public class Test2 {
  public int[] solution(int start, int end) {
    int[] answer = new int[start - end + 1];

    for (int i = start; i >= end; i--) {
      int index = start - i;
      answer[index] = i;
    }

    return answer;
  }
}
// 카운트다운

class Solution {
  public int[] solution(int start, int end) {
    int[] answer = new int[end - start + 1];

    for (int i = start; i <= end; i++) {
      int index = i - start;
      answer[index] = i;
    }

    return answer;
  }
}

// 카운터 업