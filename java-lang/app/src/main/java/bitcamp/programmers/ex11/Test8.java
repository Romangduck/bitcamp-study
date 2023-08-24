package bitcamp.programmers.ex11;

public class Test8 {
  public int solution(String my_string, String is_prefix) {
    if (my_string.startsWith(is_prefix)) {
      return 1;
    } else {
      return 0;
    }
  }
}

// 접두사인지 확인하기
// .startsWith()