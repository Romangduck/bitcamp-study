package bitcamp.programmers.ex13;

public class Test13 {
  public String solution(String cipher, int code) {
    String answer = "";

    for (int i = code - 1; i < cipher.length(); i += code) {
      answer += cipher.charAt(i);
    }

    return answer;
  }
}

// 암호 해독
// -> i += code는 반복문 내에서 i 변수의 값을 code만큼 증가시키는 표현식입니다.
// 이것은 i = i + code와 동일한 동작을 합니다.

// 주어진 solution 메서드에서는 for 반복문을 사용하여
// cipher 문자열에서 code 간격으로 문자를 추출합니다.
// i += code 표현식은 반복문이 한 번 실행될 때마다 i를 code만큼 증가시키는 역할을 합니다.

// 예를 들어, code가 3인 경우 i += code는 i = i + 3과 같으므로,
// 반복문이 한 번 실행될 때마다 i가 3씩 증가합니다.
// 이로 인해 for 반복문은 i = code - 1부터 시작하여 code 간격으로 문자를 추출하게 됩니다.

// 다시 한 번 반복문의 동작을 살펴보겠습니다:

// i 변수를 code - 1로 초기화합니다.
// 반복문이 실행될 때마다 i를 code만큼 증가시킵니다.
// 따라서 cipher 문자열에서 code 간격으로 문자를 추출합니다.
// 이러한 방식으로 for 반복문을 통해 cipher 문자열에서 code 간격으로
// 문자를 추출하여 answer 문자열에 추가하게 됩니다.
// 이렇게 생성된 answer 문자열이 최종적으로 반환되는 결과가 됩니다.