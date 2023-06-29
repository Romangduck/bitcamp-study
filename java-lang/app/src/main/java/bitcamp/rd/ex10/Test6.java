package bitcamp.rd.ex10;

public class Test6 {
  public int solution(String num_str) {
    int answer = 0;

    for (int i = 0; i < num_str.length(); i++) {
      answer += Integer.parseInt(num_str.substring(i, i + 1));
    }

    return answer;
  }
}
// 문자열 정수의합