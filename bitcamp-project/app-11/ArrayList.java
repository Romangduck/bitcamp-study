package project.util;

import project.myapp.vo.Board;

public abstract class ArrayList {
  private static final int DEFAULT_SIZE = 3;
  private Object[] list = new Object[DEFAULT_SIZE];
  private int length;

  public boolean add(Object obj) {            
    if (this.length == list.length) {
      increase();
    }

    this.list[this.length++] = obj;
    return true;
  }

// add메서드 , Object타입의 obj인자를 받음.
// 현재 크기(length)가 전체 크기와 같을때 increase() 메서드를 실행
// 실행후 , list의 크기만큼의 인덱스 , 즉 현재 list에 obj를 넣기.

  private void increase() {
    Object[] arr = new Object[list.length + (list.length >> 1)];

    for (int i = 0; i < list.length; i++) {
      arr[i] = list[i];
    }

    list = arr;

  }
// increase 메서드 , Object타입의 배열 arr 의 크기는 현재크기(list.length)값에 50프롤 더함
// 반복문을 통해 현재길이전까지 반복하여 , 기존의 값들을 (list[i]) arr에 저장
// list의 주소값은 arr과 같다.
// 정리 : 배열의 크기를 늘리고 기존의 요소들을 새로만들어진 arr 배열과 동기화하고
// 주소값도 똑같이. 


  public Object[] list() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  //Object 배열을 반환하는 list 메서드
  // 위에 과정과 같이 새로만들어진 arr배열과 동기화하는것인데
  // 쓰임의 목적 -> 외부 패키지에서 list메서드를 사용함으로
  // ArrayList 패키지의 내부요소에 접근하기위함.
  // 정리 : get,set과 같이 private 처리된 값을 불러오기위함임.
  public Object get(Object obj) {
    for (int i = 0; i < length; i++) {
      Object item = list[i];
      if (item.equals(obj)) {
        return item;
      }
    }
    return null;
  }

  // Object 타입을 반환하는 get 메서드 , Object 타입의 obj 인자를 받는다.
  // 반복문을 통해 Object 타입의 item 변수에 list[0],list[1].. 을 배정해줌
  // 그때 item 변수의 값이 obj의 값과 같다면 item 변수의 값을 출력
  // 아니면 아무것도 출력하지않음
  // 쓰임의 목적 -> item와 obj가 같을때 item 출력=> 주어진 객체(obj)와
  // 일치하는 요소(item)을 찾아서 반환

  public boolean delete(Object obj) {
    int deletedIndex = indexOf(obj);
    if (deletedIndex == -1) {
      return false;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      list[i] = list[i + 1];
    }
    list[--length] = null;
    return true;
  }

  // boolean 타입을 반환하는 delete 메서드
  // int 타입의 deletedIndex 변수에 obj의 값을 저장
  // 만약 -1이라면 false 출력 -> 번호가 일치하지않다.
  // int 타입의 deletedIndex 변수부터 시작하는 i 반복문
  // 크기에서 -1 까지범위에서 요소를 +1만큼 이동후에 크기를 1 줄임
  // 배열 삭제를 통해 요소를 삭제

  private int indexOf(Object obj) {
    for (int i = 0; i < length; i++) {
      Object item = list[i];
      if (item.equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  // get과 같은 역할이라 볼 수 있는데, 위에 delete 메서드가 boolean 타입이므로
  // 주어진 객체와 요소가 일치하다면 1 (true) 삭제
  // 아니라면 -1 (false) 아무것도 아님 
}


