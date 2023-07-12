package bitcamp.rd.ex11;

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