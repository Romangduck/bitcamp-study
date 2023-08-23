public class Test2  {
  public String solution(String my_string, int[] index_list) {
      StringBuilder answerBuilder = new StringBuilder();
      for (int i = 0; i < index_list.length; i++) {
          int index = index_list[i];
          if (index >= 0 && index < my_string.length()) {
              answerBuilder.append(my_string.charAt(index));
          }
      }
      return answerBuilder.toString();
  }
}
// 글자 이어 붙여 문자열 만들기


class Solution {
    public String solution(String my_string, int[] index_list) {

        StringBuilder sb = new StringBuilder();

        for (int idx : index_list)
            sb.append(my_string.charAt(idx));

        return sb.toString();
    }
}
