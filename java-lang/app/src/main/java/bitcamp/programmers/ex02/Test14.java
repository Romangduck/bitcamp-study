package bitcamp.programmers.ex02;

import java.util.Arrays;

public class Test14 {
  public int solution(int[] numbers) {
    int answer = 0;

    Arrays.sort(numbers);
    int num1 = numbers[0] * numbers[1];
    int num2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

    if (num1 < num2) {
      return num2;
    } else {
      return num1;
    }
  }
}

// 최댓값 만들기(2)