package bitcamp.rd.ex12;

public class Test10 {
  public int[] solution(int[] arr, int n) {
    for (int i = 0; i < arr.length; i++) {
      if (arr.length % 2 == 1 && i % 2 == 0) {
        arr[i] += n;
      }
      if (arr.length % 2 == 0 && i % 2 == 1) {
        arr[i] += n;
      }
    }
    return arr;
  }
}

class Solution {
  public int[] solution(int[] arr, int n) {
    int[] answer = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (arr.length % 2 == 0 && i % 2 != 0) {
        answer[i] = arr[i] + n;
      } else if (arr.length % 2 != 0 && i % 2 == 0) {
        answer[i] = arr[i] + n;
      } else {
        answer[i] = arr[i];
      }
    }
    return answer;
  }
}

// 배열의 길이에 따라 다른 연산하기