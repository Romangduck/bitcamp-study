package bitcamp.rd.ex02;

public class Test19 {
  public int solution(String my_string) {
    String[] strArr = my_string.split(" ");
    int answer = Integer.parseInt(strArr[0]);

    for (int i = 1; i < strArr.length; i += 2) {
      String operator = strArr[i];
      int operand = Integer.parseInt(strArr[i + 1]);

      if (operator.equals("+")) {
        answer += operand;
      } else if (operator.equals("-")) {
        answer -= operand;
      }
    }
    return answer;
  }
}

// 문자열 더하기