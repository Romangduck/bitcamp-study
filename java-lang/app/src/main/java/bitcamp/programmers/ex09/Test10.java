package bitcamp.programmers.ex09;

public class Test10 {
  public String solution(String my_string, String letter) {

    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < my_string.length(); i++) {
      char a = my_string.charAt(i);
      if (!Character.toString(a).equals(letter)) {
        answer.append(a);
      }
    }
    return answer.toString();
  }
}

//

// class Solution {
// public String solution(String my_string, String letter) {
// my_string = my_string.replace(letter, "");
// return my_string;
// }
// }

// .replace(A,B) -> A를 B로 변경 , 여기선 ""를 통해 여백으로 바꿔버림