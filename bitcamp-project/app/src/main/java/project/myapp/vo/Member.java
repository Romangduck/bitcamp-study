package project.myapp.vo;

public class Member {

  private static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  public static final char getMale() {
    return MALE;
  }

  public static final char getFemale() {
    return FEMALE;
  }

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



  public static int getUserId() {
    return userId;
  }

  public static void setUserId(int userId) {
    Member.userId = userId;
  }

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
