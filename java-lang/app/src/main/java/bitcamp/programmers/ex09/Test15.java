package bitcamp.rd.ex09;

public class Test15 {
  public String solution(String my_string) {
    String answer = "";
    char[] arr = my_string.toCharArray();

    for (char i : arr) {

      if (Character.isLowerCase(i)) {
        answer += Character.toUpperCase(i);

      } else {
        answer += Character.toLowerCase(i);
      }
    }
    return answer;
  }
}

// for(char i: arr)는 배열 arr의 각 문자를 순회하면서 순서대로 변수 i에 할당