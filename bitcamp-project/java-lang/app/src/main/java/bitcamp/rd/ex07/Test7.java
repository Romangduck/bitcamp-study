package bitcamp.rd.ex07;

import java.util.Arrays;

public class Test7 {
  public int solution(int[] array) {
    int answer = 0;
    int max = 0;

    Arrays.sort(array); // 정렬
    max = array[array.length - 1]; // max 값은 array배열의 최대값
    int count[] = new int[max + 1]; // count배열은 등장횟수를 계산하기위함
    for (int i = 0; i < array.length; i++) {
      count[array[i]]++; // array의 길이만큼 반복하며,
      // ex ) [1 1 2 2 2 3] , array[0] = 1 , array[1] = 1 ,//array[2] = 2 ,array[3] =
      // 2
      // array[4] = 2 // array[5] = 3
      // count[1] 증가 , count[1] 증가 // count[2] 증가 count[2] 증가 count[2] 증가 // count[3]
      // 증가

    }
    max = count[0];

    for (int i = 1; i < count.length; i++) {
      if (max < count[i]) {
        max = count[i];
        answer = i;
      } else if (max == count[i]) {
        answer = -1;
      }
    }
    return answer;
  }

}

// 최빈도