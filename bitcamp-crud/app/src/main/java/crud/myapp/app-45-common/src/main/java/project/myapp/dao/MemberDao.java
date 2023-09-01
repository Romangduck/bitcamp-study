package project.myapp.dao;

import java.util.List;
import project.myapp.vo.Member;

public interface MemberDao {
  void insert(Member member);

  Member findBy(int no);

  Member findByPhoneNumberAndPassword(Member m);

  int update(Member member);

  int delete(int no);

  List<Member> findAll();

}
