package bitcamp.programmers.ex13;
public class Test6  {
  public int solution(int a, int b) {
      int answer = 0;
      if(a%2==1 && b%2==1){
          answer = a * a + b * b;
      }
      else if (a % 2 == 1 || b % 2 == 1){
          answer = 2 * (a + b);
      }
      else answer = Math.abs(a-b);
      return answer;
  }
}

//주사위 1