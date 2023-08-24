package bitcamp.programmers.ex08;

public class Test2 {
  public int solution(int[] array, int n) {
    int answer = 0;
    for (int i = 0; i < array.length; i++) {
      if (n == array[i]) {
        answer++;
      }
    }
    return answer;
  }
}