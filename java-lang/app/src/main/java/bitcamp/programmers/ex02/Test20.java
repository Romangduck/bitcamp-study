package bitcamp.programmers.ex02;

public class Test20  {
    public String solution(String my_string, int m, int c) {
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            if(i % m == c-1) {
                str.append(my_string.charAt(i));
            }
        }
        
        String answer = str.toString();
        
        return answer;
    }
}
// 세로 읽기