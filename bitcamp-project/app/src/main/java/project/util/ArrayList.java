package project.util;

public class ArrayList {
  private static final int DEFAULT_SIZE = 3;
  private Object[] list = new Object[DEFAULT_SIZE];
  private int length;

  public boolean add(Object obj) {
    if (length == list.length) {
      increase();
    }

    this.list[length++] = obj;
    return true;
  }

  private void increase() {
    Object[] arr = new Object[list.length + (list.length >> 1)];

    for (int i = 0; i < list.length; i++) {
      arr[i] = list[i];
    }

    list = arr;

  }

  public Object[] list() {
    Object[] arr = new Object[length];
    for (int i = 0; i < length; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  public Object get(Object obj) {
    for (int i = 0; i < length; i++) {
      Object item = list[i];
      if (item.equals(obj)) {
        return item;
      }
    }
    return null;
  }

  public boolean delete(int no) {
    int deletedIndex = indexOf(no);
    if (deletedIndex == -1) {
      return false;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      list[i] = list[i + 1];
    }
    list[--length] = null;
    return true;
  }

  private int indexOf(Object obj) {
    for (int i = 0; i < length; i++) {
      Object item = list[i];
      if (item.equals(obj)) {
        return i;
      }
    }
    return -1;
  }
}
