package test;

public class Test10 {

  public static void main(String[] args) {

    int count = 0;

    while (count < 5) System.out.println(count++);

    System.out.println("---------------------------");


    count = 0;
    while (count < 5)
      System.out.println(count++);


    System.out.println("---------------------------");

    count = 3;
    while (count < 7) {
      System.out.println(count);
      count++;
    }
  }
}
