package bitcamp.programmers.ex11;

public class Test12 {
  public int solution(int[] num_list) {
    int a = 0;
    int b = 0;
    int answer = 0;

    for (int i = 0; i < num_list.length; i++) {
      if (i % 2 == 0) {
        a += num_list[i];
      } else {
        b += num_list[i];
      }
    }

    if (a > b) {
      answer = a;
    } else {
      answer = b;
    }

    return answer;
  }
}

// 홀수 vs 짝수
