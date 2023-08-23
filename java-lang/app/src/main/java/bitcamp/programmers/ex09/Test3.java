package bitcamp.rd.ex09;

public class Test3 {
  public int solution(int slice, int n) {
    int answer = 0;
    if (n % slice == 0) {
      answer = n / slice;
    } else {
      answer = n / slice + 1;
    }

    return answer;
  }
}

// 피자 나누기(3)