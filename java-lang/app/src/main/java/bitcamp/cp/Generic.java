package bitcamp.cp;

import java.util.ArrayList;
import java.util.List;

class Apple {
}


class Banana {
}


class FruitBox<T> {
  List<T> fruits = new ArrayList<>();

  public void add(T fruit) {
    fruits.add(fruit);
  }

  FruitBox<Person> PersonBox = new FruitBox<>();
  FruitBox<Chaining> ChainingBox = new FruitBox<>();


  public static void main(String[] args) {
    Apple[] arr = {new Apple(), new Apple()};
    FruitBox<Apple> box = new FruitBox<>(arr);

    Apple apple = (Apple) box.getFruit(0);
    Banana banana = (Banana) box.getFruit(1);
  }
}
