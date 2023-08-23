package bitcamp.rd.ex09;

public class Test7 {

}

// class Solution {
// public int[] solution(int[] numbers, int num1, int num2) {
// return numbers.substring(num1,num2);
// }
// }

// -> 실행불가
// substring 메서드를 사용하여 정수 배열에서 부분 배열을 추출하는것은 직접적으로 불가능
// 해결안
// Arrays.copyOfRange()
// 주의할점 : 메서드 안에 들어가는 파라미터의 값은 인덱스의 값임
// 파이썬에서 인덱스 생각하면 좋을듯.
// ex ; [1,2,3,4,5] - > [1:4] -> [2,3,4] "인덱스1을포함하여 4의전까지"

// class Solution {
// public int[] solution(int[] numbers, int num1, int num2) {
// int[] answer = new int[num2 - num1 + 1];

// for (int i = num1; i <= num2; i++) {
// answer[i -num1] = numbers[i];
// }

// return answer;
// }
// }

// -> 상수 타입의 answer 배열의 생성자, 크기 num2 -num1 +1
// 반복문 , i는 num1부터 시작 num2까지 반복할때마다 1씩증가
// i-num1의 배열