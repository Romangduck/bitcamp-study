package bitcamp.rd.ex12;

public class Test12 {
  public int[] solution(int n, int k) {
    int[] answer = new int[n / k];

    for (int i = 0; i < n / k; i++) {
      answer[i] = (i + 1) * k;
    }

    return answer;
  }
}

// 배열 만들기 1