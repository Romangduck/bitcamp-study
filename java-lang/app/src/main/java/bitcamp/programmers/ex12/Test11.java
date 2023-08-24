package bitcamp.programmers.ex12;

public class Test11 {
  public int solution(String my_string, String is_suffix) {
    int answer = 0;

    if (my_string.endsWith(is_suffix)) {
      answer = 1;
    }

    return answer;
  }
}

// 접미사인지 확인