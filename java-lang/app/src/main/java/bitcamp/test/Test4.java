package test;

public class Test3 {
  public static void main(String[] args) {
    byte b = 100;
    short s = 100;
    int i = 98765678;
    long l = 98765678;
    char c = 100;

    float f;
    double d;

    f = b; 
    System.out.println(f);

    f = s; 
    System.out.println(f);

    f = c; 
    System.out.println(f);

    f = i; 
    System.out.println(f);

    f = l; 
    System.out.println(f);

    d = i; 
    System.out.println(d);       

    l = 18_2345_3456_4567_5678L;
    d = l; 
    System.out.println(d);       
  }
}
