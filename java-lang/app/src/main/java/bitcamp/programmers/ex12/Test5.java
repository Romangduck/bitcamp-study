package bitcamp.programmers.ex12;

public class Test5 {
  public int solution(int[] num_list) {
    int answer = -1;

    for (int i = 0; i < num_list.length; i++) {
      if (num_list[i] < 0) {
        answer = i;
        break; // 음수가 처음 등장한 인덱스를 찾았으므로 반복문 종료
      }
    }

    return answer;
  }
}

// 첫번째로 나오는 음수