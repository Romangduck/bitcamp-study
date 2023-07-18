package project.myapp.vo;

import java.io.Serializable;

public class Member implements Serializable, CsvObject, AutoIncrement {
  private static final long serialVersionUID = 1L;
  public static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private String name; // 이름
  private int no; // 번호
  private int age; // 나이
  private int height; // 키
  private int weight; // 몸무게
  private char gender; // 성별
  private float leftEye; // 시력(좌측)
  private float rightEye; // 시력(우측)

  public Member() {
    this.no = userId++;
  }

  public Member(int no) {
    this.no = no;
  }

  public static Member fromCsv(String csv) {
    String[] values = csv.split(",");

    Member member = new Member(Integer.parseInt(values[0]));
    member.setName(values[1]);
    member.setAge(Integer.parseInt(values[2]));
    member.setHeight(Integer.parseInt(values[3]));
    member.setWeight(Integer.parseInt(values[4]));
    member.setLeftEye(Float.parseFloat(values[5]));
    member.setRightEye(Float.parseFloat(values[6]));
    member.setGender(values[7].charAt(0));

    if (Member.userId <= member.getNo()) {
      Member.userId = member.getNo() + 1;
    }

    return member;

  }

  @Override
  public String toCsvString() {

    return String.format("%d,%s,%d,%d,%d,%.1f,%.1f,%c", this.getNo(), this.getName(), this.getAge(),
        this.getHeight(), this.getWeight(), this.getLeftEye(), this.getRightEye(),
        this.getGender());
  }

  @Override
  public void updateKey() {
    if (Member.userId <= this.no) {
      Member.userId = this.no + 1;
    }
  }


  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Member m = (Member) obj;

    if (this.getNo() != m.getNo()) {
      return false;
    }
    return true;
  }



  // public static int getUserId() {
  // return userId;
  // }
  //
  // public static void setUserId(int userId) {
  // Member.userId = userId;
  // }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public float getLeftEye() {
    return leftEye;
  }

  public void setLeftEye(float leftEye) {
    this.leftEye = leftEye;
  }

  public float getRightEye() {
    return rightEye;
  }

  public void setRightEye(float rightEye) {
    this.rightEye = rightEye;
  }

}
