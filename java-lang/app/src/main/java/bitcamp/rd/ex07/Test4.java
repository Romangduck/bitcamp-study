package bitcamp.rd.ex07;

class Test4 {
  public int[] solution(String[] strList) {
    int[] answer = new int[strList.length];

    for (int i = 0; i < strList.length; i++) {
      answer[i] = strList[i].length();
    }
    return answer;

  }
}