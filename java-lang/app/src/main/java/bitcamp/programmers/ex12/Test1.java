package bitcamp.programmers.ex12;

public class Test1 {
  public String solution(String my_string, String alp) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < my_string.length(); i++) {
      char c = my_string.charAt(i);
      if (c == alp.charAt(0)) {
        c = Character.toUpperCase(c);
      }
      builder.append(c);
    }

    return builder.toString();
  }
}

// 특정한 문자를 대문자로 변환하기