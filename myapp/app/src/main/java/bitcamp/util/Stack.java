package bitcamp.util;

// LinkedList의 것을 가져오는것이 아닌 쓸 수 만 있게끔.
public class Stack extends LinkedList {

  public static void main(String[] args) {
    Stack s = new Stack();
    s.push("홍길동");
    s.push("임꺽정");
    s.push("유관순");
    s.push("안중근");
    s.push("윤봉길");

    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());

    System.out.println(s.pop());
  }

  public void push(Object value) {
    // 목록 맨 끝에 추가한다.
    // 따로 만들 필요가 없다.
    // Super 클래스에 있는 메서드를 이용하여 기능을 구현한다.
    this.add(value); // 상속 받은 메서드 = Sub 클래스에서 사용할 수 있는
                     // Super 클래스의 메서드

  }

  public Object pop() {
    if (this.size() == 0) {
      return null;
    }

    return this.remove(this.size() - 1);
  }
}
