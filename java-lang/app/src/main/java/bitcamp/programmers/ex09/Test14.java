package bitcamp.programmers.ex09;

public class Test14 {
  public int solution(String my_string) {

    my_string = my_string.replaceAll("[^\\d]", "");
    String[] arr = my_string.split("");
    int answer = 0;

    for (int i = 0; i < arr.length; i++) {
      answer += Integer.parseInt(arr[i]);

    }

    return answer;

  }
}

// ^ -> 부정을 의미함
// \\d -> 숫자를 나타냄
// 즉, [^\\d] 는 숫자를 제외한 모든 문자를 뜻함.
// my_string = my_string.replaceAll("[^\\d]", "");
// 는 my_string에 my_string에서 숫자를 제외한 모든 문자를
// "" <- 공백으로 교체한 값을 저장한다는 뜻이다.

// String[] arr = my_string.split("");에서
// split은 메서드로, 문자열을 구분자(\n), 여기서는 ("")로 나누어 분할한다.
// ""로 분할된 문자열 배열을 arr 변수에 저장
// 여기서 split을 쓰는이유*
// 주어진 문자열을 각 문자별로 분할하고 문자열 배열로 반환.
// 타입을 맞춰주기위해서