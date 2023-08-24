package bitcamp.programmers.ex13;
public class Test5  {
  public int solution(int hp) {

      int answer = hp/5 + hp % 5 /3 + hp % 5 % 3;
      
      return answer;
  }
}

// 개미군단
// 발상의 전환