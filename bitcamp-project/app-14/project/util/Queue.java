package project.util;

public class Queue extends LinkedList {

  public void offer(Object value) {
    add(value);
  }

  public Object poll() {
    if (size() == 0) {
      return null;
    }
    return remove(0);
  }
}
