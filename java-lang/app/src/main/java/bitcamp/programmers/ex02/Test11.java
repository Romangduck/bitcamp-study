package bitcamp.programmers.ex02;

public class Test11 {
  public String solution(String letter) {
    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.",
        "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
        ".--", "-..-", "-.--", "--.." };
    String[] morseString;
    morseString = letter.split(" ");

    StringBuilder sb = new StringBuilder();
    for (String word : morseString) {
      for (int i = 0; i < morse.length; i++) {
        if (word.equals(morse[i]))
          sb.append(Character.toString(i + 'a'));
      }
    }
    return sb.toString();
  }
}
// 모스부호 // 이런 노가다 . .