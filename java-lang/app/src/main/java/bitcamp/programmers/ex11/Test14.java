package bitcamp.programmers.ex11;

public class Test14 {
  public String solution(int[] numLog) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < numLog.length; i++) {
      switch (numLog[i] - numLog[i - 1]) {
        case 1 -> sb.append("w");
        case 10 -> sb.append("d");
        case -1 -> sb.append("s");
        case -10 -> sb.append("a");
      }
    }
    return sb.toString();
  }
}

// 수 조작하기 (2)
// switch (numLog[i] - numLog[i - 1]) // 기존값에서 이전값을 뺏을때 ;
// case 1 -> sb.append("w"); // 1이라면 sb에 "w"를 추가하라 !