package bitcamp.programmers.ex13;

public class Test9 {
  public int solution(String str1, String str2) {
    int answer = 0;
    if (str2.contains(str1)) {
      answer = 1;
    }
    return answer;
  }
}
// 부분 문자열