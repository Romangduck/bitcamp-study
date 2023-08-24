package bitcamp.programmers.ex07;

import java.util.Random;

public class Test8 {

  public static void main(String[] args) {
    Random random = new Random();

    double x = random.nextDouble() * 2 - 1;
    double y1 = -x + 1;
    double y2 = x + 1;

    System.out.println("Random Point (y = -x + 1): (" + x + ", " + y1 + ")");
    System.out.println("Random Point (y = x + 1): (" + x + ", " + y2 + ")");
  }
}
