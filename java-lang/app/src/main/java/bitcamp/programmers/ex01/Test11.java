package bitcamp.programmers.ex01;

public class Test11 {
  public int solution(int[] num_list) {
    int answer = 0;
    String a = "";
    String b = "";

    for (int i = 0; i < num_list.length; i++) {
      if (num_list[i] % 2 == 0) {
        a += String.valueOf(num_list[i]);
      } else {
        b += String.valueOf(num_list[i]);
      }
    }

    answer = Integer.parseInt(a) + Integer.parseInt(b);

    return answer;
  }
}
// 이어 붙인 수