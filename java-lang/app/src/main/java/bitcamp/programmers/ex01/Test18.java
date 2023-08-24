package bitcamp.programmers.ex01;

<<<<<<< HEAD
public class Test18  {
public String solution(String myString) {
	return myString.replaceAll("[^l-z]", "l");
}
}
// I로 만들기
=======
public class Test18 {
  public String[] solution(String my_string) {
    my_string = my_string.trim();

    String[] answer = my_string.split("\\s+");

    return answer;
  }
}
// \\s -> 하나의 공백만을 다룸
// \\s+ -> 여러개의 공백을 다룸

// trim() -> 문자열의 양 끝에 공백을 제거하는 메서드.
>>>>>>> c9c17e588f7e19fc458e6d588c6edfc815edfb32
