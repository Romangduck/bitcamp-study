package bitcamp.programmers.ex11;

public class Test3 {
  public int solution(int[] num_list) {
    int n1 = num_list[0];
    int n2 = num_list[0];

    for (int i = 1; i < num_list.length; i++) {
      n1 *= num_list[i];
    }

    for (int j = 1; j < num_list.length; j++) {
      n2 += num_list[j];
    }

    if (n1 > n2 * n2) {
      return 0;
    } else {
      return 1;
    }
  }
}

//원소들의 곱과합
