package bitcamp.rd.ex07;

import java.util.Arrays;

class Test6 {
  public int solution(int[] numbers) {
    Arrays.sort(numbers);
    int answer = 0;
    for (int i = 1; i < numbers.length; i++) {
      answer = numbers[i] * numbers[i - 1];
    }
    return answer;
  }
}

// import java.util.*;
// class Solution {
// public int solution(int[] numbers) {
// Arrays.sort(numbers);
// return numbers[numbers.length -1] * numbers[numbers.length -2] ;
// }
// }