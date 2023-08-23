package bitcamp.rd.ex12;

import java.util.Arrays;

public class Test6 {
  public int[] solution(int[] numList, int n) {
    return Arrays.copyOfRange(numList, n - 1, numList.length);
  }
}

// n번째 원소부터