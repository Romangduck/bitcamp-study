package bitcamp.rd.ex13;

public class Test18 {
  public int solution(String binomial) {
    int answer = 0;
    String[] splitArr = binomial.split(" ");

    if (splitArr[1].equals("+")) {
      answer = Integer.valueOf(splitArr[0]) + Integer.valueOf(splitArr[2]);
    } else if (splitArr[1].equals("-")) {
      answer = Integer.valueOf(splitArr[0]) - Integer.valueOf(splitArr[2]);
    } else if (splitArr[1].equals("*")) {
      answer = Integer.valueOf(splitArr[0]) * Integer.valueOf(splitArr[2]);
    }

    return answer;
  }
}

// 간단한 식 계산하기