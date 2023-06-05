package test;

// 번호 이름 이메일 암호 성별

import java.util.Scanner;   // Scanner 기능 삽입

public class Test14 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in); // Scanner 기능을 sc에 탑재

    final int MAX_SIZE = 100;      // 정수를 담는 로컬변수 MAX_SIZE에 100으로 초기화
    int userID = 1;  // userID라는 정수를 담는 로컬변수에 1로 초기화
    int length = 0;  // length라는 정수를 담는 로컬변수에 1로 초기화

    int[] no= new int[MAX_SIZE];   // 정수를 담는 no이라는 배열변수를 선언하고 
                                  //   배열의 크기를 MAX_SIZE로 지정 , 번호
    String[] name= new String[MAX_SIZE];  //문자열을 담는 name이라는 배열변수를 선언하고
                                          //배열의 크기를 MAX_SIZE로 지정 , 이름
    String[] email= new String[MAX_SIZE]; //똑같이 문자열을 담는 email이라는 배열변수 선언 ~
    String[] password= new String[MAX_SIZE];    // 똑같이 문자열을 담는 password라는 배열변수 선언~
    char[] gender= new char[MAX_SIZE];     // 문자형을 담는 gender라는 배열변수를 선언, 배열의 크기를 MAX_SIZE

    printTitle();

for (int i = 0; i < MAX_SIZE; i++) {
  inputMember(sc, i, name, email, password, gender, no, userID++);

  length++;

  if (!promptContinue(scanner)) {
    break;
  }
}


static void inputMember(Scanner sc, int i,
String[] name, String[] email,
String[] password, char[] gender, int[] no, int userID)



printMembers(length, no1, name1, email1, gender1);

scanner.close();

static void printTitle(){
  System.out.println("나의 목록 관리 시스템");
  System.out.println("--------------------------");
}


