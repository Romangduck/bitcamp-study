package project.util;

public class Stack<E> extends LinkedList<E> {

  public void push(E value) {
    this.add(value);
  }

  public E pop() {
    if (empty()) {
      return null;
    }
    return remove(this.size() - 1);
  }

  public E peek() {
    if (empty()) {
      return null;
    }
    return get(this.size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }
}
