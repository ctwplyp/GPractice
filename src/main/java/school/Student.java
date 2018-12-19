package school;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
  private String name;
  private double gpa;
  private List<String> courses;

  private Student() {}
  public static Student of(String name, double gpa, String... courses) {
    Student self = new Student();
    self.name = name;
    self.gpa = gpa;
    self.courses = Arrays.asList(courses);
    return self;
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public List<String> getCourses() {
    return Collections.unmodifiableList(courses);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }

  // captured variable "threshold" must be final, or effectively final
  public static StudentCriterion getSmartCriterion(double threshold) {
//    threshold += 1;
    return s -> s.gpa > threshold;
  }
}
