package bitcamp.programmers.ex01;

public class Test15 {
  public int[] solution(int[] num_list, int n) {
    int[] answer = new int[num_list.length];
    int index = 0;

    for (int i = n; i < num_list.length; i++) {
      answer[index++] = num_list[i];
    }

    for (int i = 0; i < n; i++) {
      answer[index++] = num_list[i];
    }

    return answer;
  }
}

// 순서바꾸기