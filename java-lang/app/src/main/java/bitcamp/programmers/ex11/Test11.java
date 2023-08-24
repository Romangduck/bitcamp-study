package bitcamp.programmers.ex11;

import java.util.Arrays;

class Test11 {
  public String[] solution(String my_string) {
    int max = my_string.length();
    String[] str = new String[max];

    for (int i = 0; i < max; i++) {
      str[i] = my_string.substring(i, max);

    }
    Arrays.sort(str);
    return str;
  }
}

// 접미사 배열
// substring을 사용하여 앞에서부터 분할하고 Arrays.sort를 사용하여 순서 .