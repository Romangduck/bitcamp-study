package bitcamp.rd.ex10;

public class Test2 {
  public int[] solution(int[] emergency) {

    int[] answer = new int[emergency.length];

    for (int i = 0; i < emergency.length; i++) {
      for (int j = 0; j < emergency.length; j++) {
        if (emergency[i] < emergency[j]) {
          answer[i]++;
        }
      }
      answer[i]++;
    }
    return answer;
  }
}

// i가 0일때 j가 0일때 비교하고 또 다시 돌아가서 i가 0일때 j가1 일때 비교하고
// 이러한 순서의 반복이다.