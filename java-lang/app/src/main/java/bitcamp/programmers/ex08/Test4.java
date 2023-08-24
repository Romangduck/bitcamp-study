package bitcamp.programmers.ex08;

class Test4 {
  public int[] solution(int[] num_list, int n) {
    for (int i = 0; i < num_list.length; i++) {
      if (n >= i && n % i == 0) {
        return new int[] { num_list[i] };
      }
    }
    return null;

  }
}

// class Solution {
// public int[] solution(int[] num_list, int n) {
// int[] answer;
// if (num_list.length % n == 0) {
// answer = new int[num_list.length / n];
// } else {
// answer = new int[num_list.length / n + 1];
// }

// int index = 0;
// for (int i = 0; i < num_list.length; i += n) {
// answer[index++] = num_list[i];
// }
// return answer;
// }
// }