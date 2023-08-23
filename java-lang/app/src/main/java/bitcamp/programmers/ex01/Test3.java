package bitcamp.rd.ex01;

import java.util.Scanner;

public class Test3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int n = sc.nextInt();
    int a = str.length();

    if (a >= 1 && a <= 10) {
      String repeatstr = repeatString(str, n);
      System.out.println(repeatstr);
    }
  }

  public static String repeatString(String str, int n) {
    if (n >= 1 && n <= 5) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        sb.append(str);
      }
      return sb.toString();
    }
    return "";
  }
}