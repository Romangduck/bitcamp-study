package bitcamp.rd.ex06;

public class Test7 {
  public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int top = numer1 * denom2 + numer2 * denom1;
        int bottom = denom1 * denom2;
        int a = 1;
        for(int i =1; i <= bottom bottom && i <=top; i++) {
            if(top%i==0 && bottom%i==0)
                a = i;}
        answer[0] = top/a;
        answer[1] = bottom/a;
        return answer;
        
    }
}