package test;

//# 배열 - 배열 인스턴스 메모리의 기본 값
//
public class Test9 {
  public static void main(String[] args) {


    int[] arr1 = new int[5];
    float[] arr2 = new float[5];
    boolean[] arr3 = new boolean[5];
    char[] arr4 = new char[5];
    Object[] arr5 = new Object[5];

    arr1[2] = 100;
    arr2[2] = 90;
    arr3[2] = true;
    arr4[2] = 70;
    arr5[2] = 60;

    System.out.println(arr1[2]);
    System.out.println(arr2[2]);
    System.out.println(arr3[2]);
    System.out.println(arr4[2]);
    System.out.println(arr5[2]);
    
    int[] arr= {10 ,20 , 30};
    System.out.println(arr[1]);

    int[] arr10;
    arr10 = new int[5];
    arr10[0] = 100;

    arr10 = new int[] {200, 200, 200};

    System.out.println(arr10[0]);

  }
}