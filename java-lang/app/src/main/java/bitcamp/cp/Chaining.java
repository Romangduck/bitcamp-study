package bitcamp.cp;

public class Chaining {



  // 일반메서드
  public void noChain() {
    Person person = new Person();
    person.setName("Kim");
    person.setEyecolor("Blue");
    person.setHeight("180cm");
    person.setWeight("66kg");
  }

  // 메서드 체이닝
  public void Chain() {
    Person person = new Person();
    person.setName("Kim").setEyecolor("Blue").setHeight("180cm").setWeight("66kg");
  }

}
//
// 메서드 체이닝에서 "Cannot invoke ~(String) on the primitive type void" 오류가
// 발생하는 이유는 메서드가 void 반환 유형을 가지기 때문입니다.
// void 반환 유형은 값을 반환하지 않으므로 메서드 체이닝에서 연속적으로 호출할 수 없습니다.
//
