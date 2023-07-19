package test;

public class Test13 {
  public static void main(String[] args) {
    int x = 2, y = 1;

    while (x <= 9) {

      while (y <= 9) {
        System.out.printf("%d * %d = %d\n", x, y, x * y);
        if (x == 5 && y == 5)
          break;
        y++;
      }

     
      

      System.out.println();
      
      y = 1;
      x++;
    }
    System.out.println("종료!!");
  }
}
