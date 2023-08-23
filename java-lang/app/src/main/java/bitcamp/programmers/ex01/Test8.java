package bitcamp.rd.ex01;

public class Test8 {
  public double solution(int[] arr) {
    double answer = 0;
    double arr1 = 0;
    for (int i = 0; i < arr.length; i++) {
      arr1 += arr[i];
      answer = arr1 / arr.length;
    }
    return answer;
  }
}

// 평균 구하기