package bitcamp.rd.ex09;

public class Test1 {
  public int solution(int price) {
    if (price >= 500000) {
      price *= 0.8;
    } else if (price >= 300000) {
      price *= 0.9;
    } else if (price >= 100000) {
      price *= 0.95;
    }
    return price;
  }
}

// 옷가게 할인받기
// 유의점 ; 10만원이상부터일것같지만, 50만부터로 해야함.
// -> 조건문의 첫번째를 10만으로 걸어버리면 50만은 10만의 조건을 받음