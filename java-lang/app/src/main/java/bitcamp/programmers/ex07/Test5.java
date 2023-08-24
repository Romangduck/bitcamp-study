package bitcamp.programmers.ex07;

<<<<<<< HEAD
public class Test5 {
    public String solution(String my_string, int n) {
        String str = "";
        String[] arr = my_string.split("");
        for(int i=0; i<my_string.length(); i++){
            str += arr[i].repeat(n);
        }
        return str;
    }
}
=======
import java.util.Arrays;

class Test5 {
  public int solution(int[] array) {

    Arrays.sort(array);

    int answer = array.length / 2;

    return array[answer];
  }
}

// Arrays.sort(array) -> array 배열을 정렬하기
>>>>>>> 585d0f5e5e8b05036b9eba346fc2761b2dd55e88
