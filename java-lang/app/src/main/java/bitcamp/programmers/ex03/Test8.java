package bitcamp.programmers.ex03;

public class Test8 {
  public int solution(int num, int k) {
    int answer = -1; // 초기값을 -1로 설정

    String[] arr = String.valueOf(num).split("");

    for (int i = 0; i < arr.length; i++) { // 배열 이름을 arr로 수정
      if (arr[i].equals(String.valueOf(k))) {
        answer = i + 1;
        break; // 조건을 만족하면 더 이상 반복할 필요 없음
      }
    }

    return answer; // 조건을 만족하지 않을 경우 초기값인 -1이 반환됨
  }
}

// 숫자 찾기
