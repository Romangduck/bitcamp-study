package bitcamp.programmers.ex10;

<<<<<<< HEAD
public class Test9 {
  public int solution(String str1, String str2) {
    int answer = 0;
    if (str1.contains(str2)) {
      answer = 1;

    } else {
      answer = 2;
    }
    return answer;
  }
}

// 문자열안에 문자열
// .contains
=======
public class Test {
    public static void main(String[] args) {
      System.out.println(args);
      int a = 100, b = 200;
      swap(a, b);
      System.out.printf("main(): %d, %d\n", a, b);
    }
  
    static void swap(int a, int b) {
      int temp = a;
      a = b;
      b = temp;
      System.out.printf("swap(): %d, %d\n", a, b);
    }
  }
  
>>>>>>> 1f26df85a51972d82ecbdcf83bb1674fd9885807
