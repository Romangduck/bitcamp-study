package bitcamp.programmers.ex12;

public class Test4 {
  public String solution(String myString) {
    String answer = "";
    myString = myString.toLowerCase();
    for (int i = 0; i < myString.length(); i++) {
      if (myString.charAt(i) == 'a')
        answer += Character.toUpperCase(myString.charAt(i));
      else
        answer += myString.charAt(i);
    }
    return answer;
  }
}

// A 강조하기