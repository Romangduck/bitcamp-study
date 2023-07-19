package bitcamp.rd.ex06;

public class Test3 {
  public double solution(int[] numbers) {
    double answer = 0;
    int tot = 0;
    for (int i = 0; i < numbers.length; i++) {
      tot += numbers[i];
    }
    answer = (double) tot / numbers.length;
    return answer;
  }
}

// 배열의 평균값
// tot +=numbers[i];
// * 배열의 요소를 누적하여 합하는것.