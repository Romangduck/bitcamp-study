package bitcamp.programmers.ex02;

import java.util.*;

public class Test3 {
  public List solution(String[] todo_list, boolean[] finished) {
    List<String> answer = new ArrayList<>();
    for (int i = 0; i < todo_list.length; i++) {
      if (finished[i] == false) {
        answer.add(todo_list[i]);
      }
    }
    return answer;
  }
}

// 할일 목록