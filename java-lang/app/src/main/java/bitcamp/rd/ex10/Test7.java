package bitcamp.rd.ex10;

public class Test7 {
  public int solution(int n, String control) {
    int answer = 0;
    String[] abc = control.split("");
    for (int i = 0; i < abc.length; i++) {
      switch (abc[i]) {
        case "w":
          n += 1;
          break;
        case "s":
          n -= 1;
          break;
        case "d":
          n += 10;
          break;
        case "a":
          n -= 10;
          break;
        default:
          break;
      }
    }
    answer = n;
    return answer;
  }
}

class Solution {
  public int solution(int n, String control) {
    int answer = 0;
    for (int i = 0; i < control.length(); i++) {
      if (control.charAt(i) == 'w') {
        n = n + 1;
      }
      if (control.charAt(i) == 'a') {
        n = n - 10;
      }
      if (control.charAt(i) == 's') {
        n = n - 1;
      }
      if (control.charAt(i) == 'd') {
        n = n + 10;
      }
    }
    answer = n;
    return answer;
  }
}

// 수 조작하기