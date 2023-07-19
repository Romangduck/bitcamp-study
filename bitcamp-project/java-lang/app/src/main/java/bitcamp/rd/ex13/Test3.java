public class Test3 {
  public int solution(String ineq, String eq, int n, int m) {
          if (ineq.equals(">")) {
                  if (eq.equals("=")) {
                          return n >= m ? 1 : 0;
                  } else if (eq.equals("!")) {
                          return n > m ? 1 : 0;
                  }
          } else if (ineq.equals("<")) {
                  if (eq.equals("=")) {
                          return n <= m ? 1 : 0;
                  } else if (eq.equals("!")) {
                          return n < m ? 1 : 0;
                  }
          }

          return 0; // 기본적으로 0을 반환 (조건에 맞지 않는 경우)
  }
}
//조건문자열 


class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean answer = false;
        if (ineq.equals(">") && eq.equals("="))
            answer = n >= m;
        else if (ineq.equals("<") && eq.equals("="))
            answer = n <= m;
        else if (ineq.equals(">") && eq.equals("!"))
            answer = n > m;
        else 
            answer = n < m;
        return answer ? 1 : 0;
    }
}