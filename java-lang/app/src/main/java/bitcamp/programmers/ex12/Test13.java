package bitcamp.programmers.ex12;
import java.util.*;
public class Test13 {
    public String[] solution(String[] names) {
        List<String> answerList = new ArrayList<>();
        
        while (names.length > 0) {
            String[] group = Arrays.copyOfRange(names, 0, Math.min(5, names.length));
            answerList.add(group[0]);
            names = Arrays.copyOfRange(names, Math.min(5, names.length), names.length);
        }
        
        String[] answer = new String[answerList.size()];
        answer = answerList.toArray(answer);
        return answer;
    }
}

//5명씩

// // Arrays.copyOfRange() 메소드를 사용하여 풀었다.
//  이전에 사용했던 System.arraycopy() 메소드와 비슷하지만 차이가 있다.

// // Arrays.copyOfRange()는  java.util.Arrays 클래스에서 제공된다. 
// 원본 배열의 지정된 범위를 새로운 배열로 복사하여 반환하며, 다음과 같은 형식으로 사용된다.

// Arrays.copyOfRange() 메서드를 이용하여 names 배열을 처음부터 5개씩 복사하여 group 배열에 저장.
// add() 메서드를 이용하여 group 배열의 첫 번째 요소를 answerList에 추가.
// 다시 Arrays.copyOfRange() 메서드로 names 배열을 5와 names배열의 길이중 
// 작은 값에 해당하는 자리부터 names 배열의 끝까지 복사하여 그 결과를 다시 names에 할당한다. 
// (앞서 이미 복사된 요소들을 뺀 나머지 요소들만 복사)
// 이 과정을 names 배열이 0이 될 때까지 반복.

// Math.min() 메서드를 넣은 이유 
// (Math.min(a , b) 두 개의 인수 a 와 b 중에서 작은 값을 반환하는 메서드) :
// 문제에서 5명씩 묶은 그룹의 가장 앞에 있는 사람들의 이름을 담은 리스트를 return 하라고 했기 때문에 
// names 배열의 요소들을 5개씩 묶어 구분해야했는데, 그냥 5를 넣으면 남은 요소의 수보다 5가 더 클 경우 에러가 발생한다. 
// 그래서 남은 names 배열의 요소의 수와 5를 비교하여 더 작은 쪽 만큼만 복사하도록 했다.

// 반복이 종료되면, answerList에는 모든 그룹의 가장 앞에 있는 사람의 이름이 담겨져 있다.
// answerList의 크기를 이용하여 answer 배열을 생성하고 toArray() 메서드로 
// answerList의 요소들을 배열로 변환하여 answer에 할당.




// List<String> answerList = new ArrayList<>();:
//  answerList라는 빈 문자열 리스트를 생성합니다. 이 리스트에 결과를 담아둘 것입니다.

// while (names.length > 0) { ... }: 
// 입력 names 배열의 길이가 0보다 클 때까지 반복합니다. 
// 이렇게 하면 names 배열이 비어있을 때까지 그룹을 만들어 결과 리스트에 추가할 수 있습니다.

// String[] group = Arrays.copyOfRange(names, 0, Math.min(5, names.length));: names 
// 배열의 앞쪽부터 5개의 요소를 포함하는 새로운 배열 group을 생성합니다. 
// Arrays.copyOfRange 메서드를 사용하여 배열의 일부분을 새 배열로 복사합니다. 
// 이때, Math.min(5, names.length)를 사용하여 names 배열의 길이가 5보다 작을 경우에도 올바른 범위를 설정합니다.

// answerList.add(group[0]);: 
// group 배열의 첫 번째 요소를 answerList에 추가합니다.
//  이로써 각 그룹에서 가장 앞에 있는 사람들의 이름이 순서대로 answerList에 담기게 됩니다.

// names = Arrays.copyOfRange(names, Math.min(5, names.length), names.length);: 
// 위에서 처리한 그룹을 names 배열에서 제거합니다.
//  Arrays.copyOfRange 메서드를 사용하여 남은 요소들로 names 배열을 갱신합니다.

// 반복문이 끝난 후, answerList에는 두 그룹에서 가장 앞에 있는 사람들의 이름이 순서대로 담겨 있습니다.

// String[] answer = new String[answerList.size()];:
//  결과를 저장할 새로운 String 배열 answer를 생성합니다. 
//  이 배열의 크기는 answerList의 크기와 동일합니다.

// answer = answerList.toArray(answer);:
//  answerList에 있는 요소들을 answer 배열로 복사합니다.

// return answer;:
//  최종 결과인 answer 배열을 반환합니다.


// 이렇게 구현된 코드는 names 배열을 입력받아서 각 그룹에서 가장 앞에 있는 사람들의 이름을
//  ["nami", "vex"]와 같은 형태로 반환합니다.



// class Solution {
//     public String[] solution(String[] names) {
//         String[] answer;
//         int size = names.length / 5;
//         if(names.length % 5 != 0){
//             size += 1;
//         }
//         answer = new String[size];
//         int idx = 0;
//         for(int i = 0; i < size; i++){
//             answer[i] = names[idx];
//             idx += 5;
//         }
//         return answer;
//     }
// }