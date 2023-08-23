package bitcamp.rd.ex01;

public class Test19 {
  public int solution(String myString, String pat) {
    int answer = 0;

    myString = myString.replace("A", "temp").replace("B", "A").replace("temp", "B");

    if (myString.contains(pat)) {
      answer = 1;
    }

    return answer;
  }
}

// 문자열 바꿔서 찾기
// 굳이 "temp"로 변환을 한다음에 귀찮게 바꾸는 이유 ->

class Solution {
  public int solution(String myString, String pat) {
    int answer = 0;

    myString = myString.replace("A", "B").replace("B", "A");

    if (myString.contains(pat)) {
      answer = 1;
    }

    return answer;
  }
}

// -> ABAAB가 입력값이라면 , BBBBB로 변경되고 AAAAA로 변경됨.
// -> 즉 , 구별이 안되어버림.
// 그래서 temp B temp temp B -> temp A temp temp A
// B A B B A (원하는값을 얻을 수 있음)