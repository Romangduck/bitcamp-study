package project.myapp.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;


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
  private String handPhone; // 핸드폰번호
  private Date createdDate; // 등록일
  private String password; // 비밀번호



  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    return no == other.no;
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



  public String getHandPhone() {
    return handPhone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setHandPhone(String handPhone) {
    this.handPhone = handPhone;
  }
}
