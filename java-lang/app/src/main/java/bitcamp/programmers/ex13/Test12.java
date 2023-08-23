package bitcamp.rd.ex13;

public class Test12 {
  public int solution(String myString, String pat) {
    int answer = 0;
    myString = myToLower(myString);
    pat = myToLower(pat);
    if (myString.contains(pat)) {
      answer = 1;
    }
    return answer;
  }

  // 직접 정의한 문자열 소문자로 변환 메서드
  private String myToLower(String input) {
    if (input == null) {
      return null;
    }
    return input.toLowerCase();
  }
}

// 원하는 문자열 찾기

class Solution {
  public int solution(String myString, String pat) {
    int answer = 0;
    if (myString.toLowerCase().contains(pat.toLowerCase())) {
      answer = 1;
    }
    return answer;
  }
}