import java.util.ArrayList;
import java.util.Arrays;

class Test7 {
  public String[] solution(String myString) {
    String[] splitArr = myString.split("x");
    ArrayList<String> resultList = new ArrayList<>();

    for (String str : splitArr) {
      if (!str.isEmpty()) {
        resultList.add(str);
      }
    }

    String[] resultArr = resultList.toArray(new String[resultList.size()]);
    Arrays.sort(resultArr);

    return resultArr;
  }
}

// 문자열 잘라서 정리하기