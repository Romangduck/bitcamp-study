package bitcamp.rd.ex07;

import java.util.Arrays;

class Test5 {
  public int solution(int[] array) {

    Arrays.sort(array);

    int answer = array.length / 2;

    return array[answer];
  }
}

// Arrays.sort(array) -> array 배열을 정렬하기
