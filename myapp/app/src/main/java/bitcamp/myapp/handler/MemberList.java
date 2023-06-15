package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;

public class MemberList {

  private static final int MAX_SIZE = 100;
  private Member[] members = new Member[MAX_SIZE];
  private int length;

  public void add(Member m) {
    if (!available())
      this.members[this.length++] = m;

  }

  public boolean available() {
    return this.length < MAX_SIZE;
  }
}
