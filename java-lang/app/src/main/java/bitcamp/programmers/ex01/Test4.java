package bitcamp.programmers.ex01;

import java.util.Scanner;

public class Test4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    String converted = convertCase(a);
    System.out.println(converted);
  }

  public static String convertCase(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isUpperCase(ch)) {
        sb.append(Character.toLowerCase(ch));
      } else if (Character.isLowerCase(ch)) {
        sb.append(Character.toUpperCase(ch));
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}