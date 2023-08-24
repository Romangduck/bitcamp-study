package bitcamp.programmers.ex03;

public class Test1 {

  public String solution(String str1, String str2) {
    String answer = "";

    for (int i = 0; i < str1.length(); i++) {
      answer += str1.substring(i, i + 1);
      answer += str2.substring(i, i + 1);
    }

    return answer;
  }
}

// 문자열 str1과 str2가 같음, 반복문을 돌려 str1 에서 한번 str2에서 한번씩

// StringBuilder

// StringBuilder 는 문자열을 동적으로 조작하기 위한 클래스이다.
// 가변적인 문자열을 생셩하고 수정할 수 있다.
// String 객체는 불변하기 때문에 문자열을 변경할 때 마다 새로운 String 객체를 생성하고
// 이전 문자열을 버리는 작업이 필요함.
// StringBuilder 는 내부 버퍼를 활용하여 문자열을 수정함.