package bitcamp.rd.ex01;

import java.util.Scanner;

public class Test2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    if (a >= -100000 && b <= 100000) {
      System.out.printf("a=%d\nb=%d\n", a, b);
    }

  }
}