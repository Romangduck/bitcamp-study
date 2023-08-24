package bitcamp.programmers.ex12;

public class Test7 {
    public int solution(String my_string, String target) {
        int answer = 0;
        if(my_string.contains(target)){
            answer = 1;
        }
        return answer;
    }
}

//부분 문자열인지 확인하기