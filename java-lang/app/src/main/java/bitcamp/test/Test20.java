package test;

import java.util.Scanner;

public class Test20 {
  static Scanner sc = new Scanner(System.in);
  static int i = 0;

  public static void main(String[] args) {
    String[] food = { "곱창" , "피자" , "국밥" , "파스타", "김찌" , "짬뽕"};

    for (String foods : food)
      System.out.println(foods);






  do
    System.out.println(i++);
    while(i<10);

    System.out.println("---------------");
    
    i = 1;
  do{
    i++;
      System.out.println(i);
    } while (i < 10);
  }
}
