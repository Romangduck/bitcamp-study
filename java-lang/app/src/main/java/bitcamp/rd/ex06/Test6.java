package bitcamp.rd.ex06;

public class Test6 {
  public int solution(String[] s1, String[] s2) {
    int result = 0;

    for (int i = 0; i < s1.length; i++) {
      for (int j = 0; j < s2.length; j++) {
        if (s1[i].equals(s2[j])) {
          result++;
        }
      }
    }
    return result;
  }
}

// 배열의 유사