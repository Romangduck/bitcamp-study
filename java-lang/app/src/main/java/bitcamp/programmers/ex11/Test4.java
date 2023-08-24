package bitcamp.programmers.ex11;

public class Test4 {
  public int[] solution(int[] num_list, int n) {
    int[] answer = new int[n]; // 배열 크기를 n으로 초기화
    for (int i = 0; i < n; i++) {
      // 배열 처리 로직 추가
      answer[i] = num_list[i]; // num_list 배열의 값 복사
    }
    return answer; // 배열 전체를 반환
  }
}

// n번째 원소까지
// import java.util.Arrays;

// class Solution {
// public int[] solution(int[] num_list, int n) {
// return Arrays.copyOfRange(num_list, 0, n);
// }
// }