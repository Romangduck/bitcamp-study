package project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.myapp.dao.MemberDao;
import project.myapp.vo.Member;
import project.util.DataSource;

public class MySQLMemberDao implements MemberDao {

  DataSource ds;

  public MySQLMemberDao(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public void insert(Member member) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "insert into project_member(name, age, height, weight, gender, leftEye, rightEye, handPhone, Password) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, sha1(?))")) {

      stmt.setString(1, member.getName());
      stmt.setInt(2, member.getAge());
      stmt.setInt(3, member.getHeight());
      stmt.setInt(4, member.getWeight());
      stmt.setString(5, String.valueOf(member.getGender()));
      stmt.setFloat(6, member.getLeftEye());
      stmt.setFloat(7, member.getRightEye());
      stmt.setString(8, member.getHandPhone());
      stmt.setString(9, member.getPassword());

      stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Member> list() {
    try (
        PreparedStatement stmt = ds.getConnection(false).prepareStatement(
            "select member_no, name, age, height, weight, gender,leftEye,rightEye,handPhone "
                + "from project_member " + "order by name asc");

        ResultSet rs = stmt.executeQuery()) {

      List<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member m = new Member();
        m.setNo(rs.getInt("member_no"));
        m.setName(rs.getString("name"));
        m.setAge(rs.getInt("age"));
        m.setHeight(rs.getInt("height"));
        m.setWeight(rs.getInt("weight"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setLeftEye(rs.getFloat("leftEye"));
        m.setRightEye(rs.getFloat("rightEye"));
        m.setHandPhone(rs.getString("handPhone"));

        list.add(m);
      }

      return list;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "select member_no, name, age, height, weight, gender,leftEye,rightEye,handPhone,created_date "
            + "from project_member" + " where member_no=?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Member m = new Member();
          m.setNo(rs.getInt("member_no"));
          m.setName(rs.getString("name"));
          m.setAge(rs.getInt("age"));
          m.setHeight(rs.getInt("height"));
          m.setWeight(rs.getInt("weight"));
          m.setGender(rs.getString("gender").charAt(0));
          m.setLeftEye(rs.getFloat("leftEye"));
          m.setRightEye(rs.getFloat("rightEye"));
          m.setHandPhone(rs.getString("handPhone"));
          m.setCreatedDate(rs.getDate("created_date"));
          return m;
        }

        return null;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Member findByPhoneNumberAndPassword(Member param) {
    try (PreparedStatement stmt = ds.getConnection(false)
        .prepareStatement("select member_no, name, handPhone, gender, created_date"
            + " from project_member" + " where handPhone=? and password=sha1(?)")) {

      stmt.setString(1, param.getHandPhone());
      stmt.setString(2, param.getPassword());

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Member m = new Member();
          m.setNo(rs.getInt("member_no"));
          m.setName(rs.getString("name"));
          m.setHandPhone(rs.getString("handPhone"));
          m.setGender(rs.getString("gender").charAt(0));
          m.setCreatedDate(rs.getDate("created_date"));
          return m;
        }
        return null;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Member member) {
    try (PreparedStatement stmt = ds.getConnection(false)
        .prepareStatement("update project_member set " + "name=?, " + "age=?, " + "height=?, "
            + "weight=?, " + "gender=?, " + "leftEye=?, " + "rightEye=?, " + "handPhone=?, "
            + "password=sha1(?) " + "where member_no=?")) {

      stmt.setString(1, member.getName());
      stmt.setInt(2, member.getAge());
      stmt.setInt(3, member.getHeight());
      stmt.setInt(4, member.getWeight());
      stmt.setString(5, String.valueOf(member.getGender()));
      stmt.setFloat(6, member.getLeftEye());
      stmt.setFloat(7, member.getRightEye());
      stmt.setString(8, member.getHandPhone());
      stmt.setString(9, member.getPassword());
      stmt.setInt(10, member.getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement stmt =
        ds.getConnection(false).prepareStatement("delete from project_member where member_no=?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
