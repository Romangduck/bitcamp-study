package bitcamp.programmers.ex01;

class Test14 {
  public int[] solution(int[] array) {
    int[] answer = new int[2];

    if (array.length == 0) {
      answer[0] = 0;
      answer[1] = 0;
      return answer;
    }

    // 배열의 가장 큰 값과 해당 값의 인덱스를 저장할 변수를 초기화합니다.
    int maxVal = array[0];
    int maxIdx = 0;

    // 가장 큰 값을 찾기 위해 배열의 모든 원소를 순회합니다.
    for (int i = 1; i < array.length; i++) {
      if (array[i] > maxVal) {
        maxVal = array[i];
        maxIdx = i;
      }
    }

    // 가장 큰 값과 해당 값의 인덱스를 answer 배열에 저장합니다.
    answer[0] = maxVal;
    answer[1] = maxIdx;

    return answer;
  }
}

// 가장 큰 수 찾기

class Solution {
  public int[] solution(int[] array) {
    int[] answer = new int[2];

    for (int i = 0; i < array.length; i++) {
      if (array[i] > answer[0]) {
        answer[0] = array[i];
        answer[1] = i;
      }
    }

    return answer;
  }
}