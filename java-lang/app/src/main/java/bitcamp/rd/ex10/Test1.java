package bitcamp.rd.ex10;

public class Test1 {
  public String solution(int age) {
    String answer = "";
    String age962 = "abcdefghij";
    String[] ageArr = String.valueOf(age).split("");

    for (int i = 0; i < ageArr.length; i++) {
      answer += age962.charAt(Integer.valueOf(ageArr[i]));
    }
    return answer;
  }
}

// 외계행성 나이구하기