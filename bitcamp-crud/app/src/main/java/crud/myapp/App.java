package crud.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("아파트 관리 시스템");

    Scanner sc = new Scanner(System.in);


    int no = 100;
    int bdno = 201;
    int rmno = 1703;
    String password = "1234";
    boolean pet = true;

    System.out.printf("번호: %d\n", no);
    System.out.printf("동 : %d\n", bdno);
    System.out.printf("호수 : %d\n", rmno);
    System.out.printf("비밀번호: %s\n", password);
    System.out.printf("반려동물 : %b\n", pet);
  }

}
