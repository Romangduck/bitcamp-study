package bitcamp.programmers.ex13;

import java.util.Arrays;

class Test10 {
  public int[] solution(String my_string) {
    my_string = my_string.replaceAll("[a-z]", "");
    int[] answer = new int[my_string.length()];

    for (int i = 0; i < my_string.length(); i++) {
      answer[i] = Integer.parseInt(String.valueOf(my_string.charAt(i)));
    }

    Arrays.sort(answer);
    return answer;
  }
}
