package bitcamp.programmers.ex02;
public class Test2 {
  public String solution(String my_string) {
    String answer = "";
    for (int i = 0; i < my_string.length(); i++) {
      if (!answer.contains(String.valueOf(my_string.charAt(i)))) {
        answer += my_string.charAt(i);
      }
    }
    return answer;
  }
}

// 중복된 문자 제거