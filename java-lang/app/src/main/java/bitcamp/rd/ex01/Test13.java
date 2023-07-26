package bitcamp.rd.ex01;

import java.util.*;

public class Test13 {
  public int[] solution(int[] arr) {
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i]; j++) {
        answer.add(arr[i]);
      }
    }

    int[] result = new int[answer.size()];
    for (int i = 0; i < answer.size(); i++) {
      result[i] = answer.get(i);
    }

    return result;
  }
}

// 배열의 원소만큼 추가하기
