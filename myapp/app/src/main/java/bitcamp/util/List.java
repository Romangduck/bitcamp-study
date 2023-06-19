package bitcamp.util;

public interface List {
  boolean add(Object value);

  // add(Object value); => 시그너쳐
  Object get(int index);

  Object[] toArray();

  Object remove(int index);

  boolean remove(Object value);

  int size();

}
