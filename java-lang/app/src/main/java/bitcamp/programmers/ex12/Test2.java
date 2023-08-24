package bitcamp.programmers.ex12;

import java.util.Arrays;

public class Test2 {
  public int[] solution(int[] num_list) {
    Arrays.sort(num_list);

    return Arrays.copyOfRange(num_list, 0, 5);
  }
}

// 뒤에서 5등 까지