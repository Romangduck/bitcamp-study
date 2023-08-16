package bitcamp.rd.ex02;

public class Test17 {
  public int solution(int n) {
    int[] list = new int[n]; // 배열 크기를 n으로 초기화합니다.
    int count = 0; // 현재 배열에 저장된 요소의 개수를 나타내는 변수입니다.

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        list[count] = i; // 현재 요소를 배열에 추가합니다.
        count++; // 배열에 저장된 요소 개수를 증가시킵니다.
      }
    }

    int answer = 0; // 최종 결과를 저장하는 변수입니다.

    for (int j = 0; j < count; j++) {
      answer += list[j]; // 배열에 저장된 요소들을 모두 더하여 결과값을 계산합니다.
    }

    return answer;
  }
}

// 약수의 합