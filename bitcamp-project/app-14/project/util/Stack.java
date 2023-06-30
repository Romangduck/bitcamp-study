package project.util;

public class Stack extends LinkedList {

  public void push(Object value) {
    add(value);
  }

  public Object pop() {
    if (empty()) {
      return null;
    }
    return remove(size() - 1);
  }

  public Object peek() {
    if (empty()) {
      return null;
    }
    return get(size() - 1);
  }

  public boolean empty() {
    return size() == 0;
  }
}
