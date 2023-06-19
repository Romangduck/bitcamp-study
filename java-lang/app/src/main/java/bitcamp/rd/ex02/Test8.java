package bitcamp.rd.ex02;

import java.util.Scanner;

// public class Test8 {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     String input = sc.next();
//     if (input.length() >= 1 && input.length() <= 10) {

//       for (int i = 0; i < input.length(); i++) {
//         char c = input.charAt(i);
//         System.out.println(c);

//       }
//     }
//   }
// }

// *

// package bitcamp.rd.ex02;

// import java.util.Scanner;

// public class Test8 {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// String input = sc.next();
// if (input.length() >= 1 && input.length() <= 10) {

// for (int i = 0; i < input.length(); i++) {
// char c = input.charAt(i);
// System.out.print(i);
// System.out.println(c);

// }
// }
// }
// }
// chatAt() -> 문자열의 인덱스 () 안에 위치한 문자를 반환.

// 출력값에 주목

// abcde
// 0a
// 1b
// 2c
// 3d
// 4e

// import java.util.Scanner;

public class Test8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    for (char ch : a.toCharArray())
      System.out.println(ch);
  }
}

// * a.toCharArray()

// 위 메서드를 호출하면 문자열을 구성하는 각 문자가
// 순서대로 저장된 char 타입의 배열이 반환됩니다