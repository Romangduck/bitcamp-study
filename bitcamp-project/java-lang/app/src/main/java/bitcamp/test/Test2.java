package test;

public class Test2 {

  public static void main(String[] args) {

    byte b = 100; 
    short s = 32767; 
    long i = 987656780672832190381903316767L; 
    long l = 18_2345_3456_4567_5678L; 

    float f;
    double d;

    f = b;
    System.out.println(f);

    f = s; 
    System.out.println(f);

    f = i; 
    System.out.println(f);

    f = l; 
    System.out.println(f);

    d = i; 
    System.out.println(d);       

    d = l; 

    System.out.println(d);       
  }
}

