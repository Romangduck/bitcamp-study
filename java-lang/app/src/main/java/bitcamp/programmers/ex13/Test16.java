package bitcamp.programmers.ex13;

import java.util.*;

public class Test16 {
  public boolean solution(String s) {
    if (s.length() == 4 || s.length() == 6)
      return s.matches("(^[0-9]*$)");
    return false;
  }
}
