package test;

import java.util.Scanner;

public class Test16 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("오늘 얼마나 공부를 했나요?");
    int time = sc.nextInt();
    
    if (time <2) 
      System.out.println("정신 차리세요.");
    else if (time <4)
      System.out.println("밥값이 아깝습니다, 노력하세요.");
    else if (time <6)
      System.out.println("그정도로는 취업할 수 없습니다.");
    else if (time < 8)
      System.out.println("조금만 더 노력해봐요.");
    else if (time < 10)
      System.out.print("아주 잘하고 있어요.");
    else 
      System.out.print("휴식도 좋답니다.");     

          
        
      
    
    sc.close();
  }
}
