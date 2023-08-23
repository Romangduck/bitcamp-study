package bitcamp.rd.ex09;

public class Test4 {
  public String solution(String my_string) {
    String answer = "";
    int a = my_string.length();
    for (int i = 0; i < my_string.length(); i++) {
      answer += my_string.charAt(a - i - 1);
    }
    return answer;
  }
}

// 문자열 뒤집기

// public class Test 4
// {

// public String solution(String my_string) {
// String answer = "";
// for (int i = my_string.length() - 1; i >= 0; i--) {
// answer += my_string.substring(i, i + 1);
// }
// return answer;
// }
// }

// import java.util.*;

// class Solution {
// public String solution(String my_string) {
// StringBuilder sb = new StringBuilder();
// sb.append(my_string);
// sb.reverse();

// return sb.toString();
// }
// }