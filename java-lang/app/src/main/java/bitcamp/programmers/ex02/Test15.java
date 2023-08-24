package bitcamp.programmers.ex02;

import java.util.Arrays;

public class Test15 {
  public int[] solution(String myString) {

    return Arrays.stream(myString.split("x", myString.length()))
        .mapToInt(x -> x.length())
        .toArray();

  }
}

// x 사이의개수 (람다)

class Solution {
  public int[] solution(String myString) {
    String[] splitArr = myString.split("x", myString.length());
    int[] answer = new int[splitArr.length];
    for (int i = 0; i < splitArr.length; i++)
      answer[i] = splitArr[i].length();
    return answer;
  }
}

// x 사이의개수 (split을 이용한)
