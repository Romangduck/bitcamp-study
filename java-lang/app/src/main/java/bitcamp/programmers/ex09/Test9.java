package bitcamp.rd.ex09;

public class Test9 {
  public String solution(String my_string, int n) {
    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < my_string.length(); i++) {
      char a = my_string.charAt(i);
      String repeat = String.valueOf(a).repeat(n);
      answer.append(repeat);

    }
    return answer.toString();

  }

}

// StringBuilder 는 문자열을 효율적으로 다루기위해 사용됨
// append(str): StringBuilder 객체에 문자열 str을 뒤에 추가합니다.
// insert(index, str): index 위치에 문자열 str을 삽입합니다.
// delete(start, end): start부터 end-1까지의 문자열을 삭제합니다.
// reverse(): 문자열을 역순으로 변환합니다.
// toString(): StringBuilder 객체에 저장된 문자열을 반환합니다.
// char 타입의 a 는 my_string의 i번째 배열을 담음.
// valueOf를 통해 주어진 값을 문자열로 변경하고 .repeat을통해반복
// .append() 을통해 문자열들을 붙혀줌.

// return answer.toString()는 StringBuilder 객체인 answer를
// 문자열로 변환하여 반환하는 코드입니다.
