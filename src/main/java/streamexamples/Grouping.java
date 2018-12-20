package streamexamples;

import school.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grouping {
  public static String letterGrade(Student s) {
    double gpa = s.getGpa();
    if (gpa > 3.7) return "A";
    if (gpa > 3.0) return "B";
    return "C";
  }
  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        Student.of("Fred", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Fred2", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Jim", 2.7, "Art", "Philosophy"),
        Student.of("Sheila", 3.9, "Math", "Physics", "Astronomy", "Quantum Mechanics")
    );
    roster.stream()
        .collect(Collectors.groupingBy(s -> letterGrade(s)))
        .forEach((k, v) ->
            System.out.println("Students with grade " + k + " are " + v));

  }
}
