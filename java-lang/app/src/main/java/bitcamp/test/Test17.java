package test;

import java.util.Scanner;

public class Test17 { 

  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("희망하는직종");
    System.out.println("1.회계");
    System.out.println("2.일반사무");
    System.out.println("3.영업");
    System.out.println("희망 직종에 숫자를 입력하세요.");

    int i = sc.nextInt();
 

    System.out.println(" 요구되는 역량은 이와 같습니다.");

    switch (i) {
      case 1:
        System.out.println("회계능력");

      case 2:
        System.out.println("사무능력");

      case 3:
        System.out.println("객기와패기");
        break;
      default:
        System.out.println("올바른 숫자를 입력하세요");
      
      
    }
    sc.close();

  }
}