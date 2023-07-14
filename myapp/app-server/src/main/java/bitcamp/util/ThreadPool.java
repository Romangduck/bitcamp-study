package bitcamp.util;

import java.util.ArrayList;

public class ThreadPool implements ResourcePool<ManagedThread> {

  ArrayList<ManagedThread> list = new ArrayList<>();

  @Override
  public ManagedThread getResource() {
    if (list.size() == 0) {
      System.out.println("새 스레드 생성!");
      return new ManagedThread(this);
    }
    System.out.println("기본 스레드 리턴");
    return list.remove(0);
  }

  @Override
  public void returnResource(ManagedThread resource) {
    list.add(resource);
  }
}
