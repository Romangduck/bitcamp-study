package bitcamp.programmers.ex02;

public class Test10 {
  public static String solution(String myString, String overwriteString, int s) {
    int length = overwriteString.length();
    return myString.substring(0, s) + overwriteString + myString.substring(s + length);
  }
}

// .substring(a,b) => 인덱스 a 부터 인덱스 b 까지 출력