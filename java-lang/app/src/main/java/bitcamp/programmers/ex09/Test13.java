package bitcamp.programmers.ex09;

public class Test13 {
  public int solution(int n) {
    int answer = 0;
    String a = Integer.toString(n);
    for (int i = 0; i < a.length(); i++) {
      answer += Integer.parseInt(a.substring(i, i + 1));
    }
    return answer;
  }
}

// int 타입의 answer 선언
// 매개변수 n을 문자열로 변환
// 반복문을 통해, 문자열로 변환된 값을 substring(i,i+1)을 통해서 막 자릿수에 값을
// Integer.parseInt를 통해서 int타입으로 변환후에 모두 더한값.