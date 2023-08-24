package bitcamp.programmers.ex01;
import java.util.ArrayList;
import java.util.List;
public class Test17 
     {
        public String[] solution(String[] strArr) {
            List<String> answer = new ArrayList<>();
            
            for (String str : strArr) {
                if (!str.contains("ad")) {
                    answer.add(str);
                }
            }
            return answer.toArray(new String[0]);
        }
    }