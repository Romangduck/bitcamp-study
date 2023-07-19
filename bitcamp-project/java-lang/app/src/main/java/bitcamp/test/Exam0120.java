package bitcamp;


public class Exam0120 {
  public static void main(String[] args) {


    System.out.printf("Hello!\n");


    System.out.printf("이름: %s\n", "홍길동");
    System.out.printf("안녕하세요! %s입니다.\n", "임꺽정");


    System.out.printf("%d %x %c %b\n", 65, 65, 65, false);

    System.out.printf("%d %1$x %1$c\n", 65);
    System.out.printf("%3$d %1$x %2$c\n", 65, 66, 67); 


    System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");
    System.out.printf("'%-10d' '%10d'\n", 12345, 12345);


    System.out.printf("'%010d' '%07d'\n", 12345, 12345);
    System.out.printf("'%+010d' '%+07d'\n", 12345, -12345);
  }
}
















