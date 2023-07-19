package bitcamp.cp;

public class Person {

  private String name;
  private String eyecolor;
  private String height;
  private String weight;

  public String getName() {
    return name;
  }

  public String getEyecolor() {
    return eyecolor;
  }

  public String getHeight() {
    return height;
  }

  public String getWeight() {
    return weight;
  }

  public Person setName(String name) {
    this.name = name;
    return this;
  }

  public Person setEyecolor(String eyecolor) {
    this.eyecolor = eyecolor;
    return this;
  }

  public Person setHeight(String height) {
    this.height = height;
    return this;
  }

  public Person setWeight(String weight) {
    this.weight = weight;
    return this;
  }
}
