package bitcamp.programmers.ex13;
public class Test1  {
  public String solution( String rsp) {
      String answer = "";
      String [] strArr = rsp.split("");
      for(int i =0; i < strArr.length; i++) {
          if(strArr[i].equals("2")) answer+="0";
          else if(strArr[i].equals("0")) answer+="5";
          else if(strArr[i].equals("5")) answer+="2";
      }
      return answer;
  }
}

// 가위바위보 

class Solution {
  public String solution(String rsp) {
      String answer = "";
      if (rsp.equals("2")) {
          answer = "0";
      } else if (rsp.equals("0")) {
          answer = "5";
      } else if (rsp.equals("5")) {
          answer = "2";
      }
      return answer;
  }
}
