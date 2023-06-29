package bitcamp.rd.ex10;

public class Test5 {
  public int solution(int[] num_list, int n) {
    for (int i = 0; i < num_list.length; i++) {
      if (num_list[i] == n) {
        return 1;
      }
    }
    return 0;
  }
}

// 정수찾기