package functional;

import school.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Combinations {
  public static <E> Predicate<E> negate(Predicate<E> pred) {
    return x ->  !pred.test(x);
  }

  public static <E> Predicate<E> and(Predicate<E> first, Predicate<E> second) {
    return x -> first.test(x) && second.test(x);
  }

  public static <E> Predicate<E> or(Predicate<E> first, Predicate<E> second) {
    return x -> first.test(x) || second.test(x);
  }

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        Student.of("Fred", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Jim", 2.7, "Art", "Philosophy"),
        Student.of("Sheila", 3.9, "Math", "Physics", "Astronomy", "Quantum Mechanics")
    );

    Predicate<Student> smartish = s -> s.getGpa() > 3.0;
    Predicate<Student> verySmart = s -> s.getGpa() > 3.7;

    roster.stream()
        .filter(smartish)
        .map(Student::getName)
        .forEach(System.out::println);
    System.out.println("-------------------------");

    roster.stream()
        .filter(negate(smartish))
        .map(Student::getName)
        .forEach(System.out::println);
    System.out.println("-------------------------");

    roster.stream()
        .filter(and(smartish, negate(verySmart)))
        .map(Student::getName)
        .forEach(System.out::println);
    System.out.println("-------------------------");

    roster.stream()
        .filter(or(negate(smartish), verySmart))
        .map(Student::getName)
        .forEach(System.out::println);
    System.out.println("-------------------------");

    roster.stream()
        .filter(smartish.and(verySmart.negate()))
        .map(Student::getName)
        .forEach(System.out::println);
    System.out.println("-------------------------");

    roster.stream()
        .sorted(Comparator.comparing(Student::getGpa).reversed())
        .forEach(System.out::println);
    System.out.println("-------------------------");

  }
}
