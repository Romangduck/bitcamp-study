package bitcamp.rd.ex03;

public class Test4 {
  public int solution(int a, int b) {
    String ab = Integer.toString(a) + Integer.toString(b);
    String ba = Integer.toString(b) + Integer.toString(a);

    int abAnswer = Integer.parseInt(ab);
    int baAnswer = Integer.parseInt(ba);

    return Math.max(abAnswer, baAnswer);

  }
}

// ^^ Integer. => 자바에서 제공하는 클래스로, 정수 값을 다루는 데 사용됨.
// 정수 값에 대한 래퍼 클래스로서, [ 정수를 객체로 다룰 수 있게 해주는 역할]

// .toString(a); => a를 "a"로, 즉 객체의 문자열 표현을 반환함.
// 즉 , public int solution(int a, int b) {
// String ab = Integer.toString(a) + Integer.toString(b); }는
// ab라는 문자열 변수는 정수 a를 문자열로 변환하고
// * valueOf() 메서드는 주어진 인자를 해당 타입의 상수로 변환하여
// 반환하는 정적 메서드입니다. Integer.valueOf() 메서드는 정수 값을 Integer 객체로 변환합니다. */

// Math.max(a,b); => 'a'와'b'중 더 큰 값을 반환하는 정적 메서드.

// class Solution {
// public int solution(int a, int b) {
// return Math.max(Integer.parseInt(a + "" + b), Integer.parseInt(b + "" + a));
// }
// }

// * a + "" + b 는 a와b를 문자열로 변환하고 이어붙이는 연산을 수행하는 코드 !