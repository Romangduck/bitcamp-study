package bitcamp.rd.ex07;

public class Test1 {
    public int solution(int n) {
        int pizza = (n + 6) / 7;
        return pizza;
    }
}



// class Solution {
//     public int solution(int n) {
//         return n%7 == 0 ? n/7 : n/7+1;

//     }
// }

// n을 7로 나눴을때 
// 나머지가 0이면 n/7을 아니라면 n/7에 1을 더한값을 출력