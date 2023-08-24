package bitcamp.programmers.ex01;

public class Test10 {
  public String solution(String[] str_list, String ex) {
    String answer = "";
    for (int i = 0; i < str_list.length; i++) {
      if (!str_list[i].contains(ex)) {
        answer += str_list[i];
      }
    }
    return answer;
  }
}

// 배열 하나하나씩뽑아서 answer에 저장 ( if ex를 포함하지않는다면 //)