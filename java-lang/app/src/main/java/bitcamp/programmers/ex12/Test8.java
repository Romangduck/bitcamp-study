package bitcamp.programmers.ex12;
import java.util.*;

class Test8 {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i = l; i<=r; i++) {
            String str = i + "";
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 48 || str.charAt(j) == 53) {
                    count ++;
                }
            }
            if(count == str.length()) {
                list.add(i);
            }
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        int[] empty = {-1};
        if(answer.length == 0) return empty;
        return answer;
    }
}

//배열 만들기(2)