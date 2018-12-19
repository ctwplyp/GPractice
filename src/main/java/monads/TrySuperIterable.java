package monads;

import school.Student;

import java.util.Arrays;
import java.util.List;

public class TrySuperIterable {
  public static void main(String[] args) {
    SuperIterable<Student> roster = new SuperIterable(Arrays.asList(
        Student.of("Fred", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Jim", 2.7, "Art", "Philosophy"),
        Student.of("Sheila", 3.9, "Math", "Physics", "Astronomy", "Quantum Mechanics")
    ));

    roster
        .filter(s -> s.getGpa() > 3.0)
        .map(s -> s.getName() + " has grade " + s.getGpa())
        .forEach(System.out::println /* s -> System.out.println(s)*/);
    System.out.println("--------------------------");
    roster
        .filter(s -> s.getGpa() > 3.0)
        .flatMap(s -> new SuperIterable(s.getCourses()))
        .map(s -> s + " is being taken")
        .forEach(System.out::println);
  }
}
