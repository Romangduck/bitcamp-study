package bitcamp.rd.ex02;

import java.util.Scanner;

public class Test9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n >= 1 && n <= 1000 && n % 2 == 0) {
      System.out.printf("%d is even", n);
    } else {
      System.out.printf("%d is odd", n);
    }
  }
}

// import java.util.Scanner;

// public class Solution {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();

// System.out.print(n + " is "+(n % 2 == 0 ? "even" : "odd"));

// }
// }

// 조건부 연산자 '?' -> 조건이 참인경우 앞에값 거짓이면 뒤의값
// ex) 조건식 ? 참인 경우의 표현식 : 거짓인 경우의 표현식
// n % 2 "even" : "odd"