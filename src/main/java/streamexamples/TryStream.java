package streamexamples;

import monads.SuperIterable;
import school.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TryStream {
  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        Student.of("Fred", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Jim", 2.7, "Art", "Philosophy"),
        Student.of("Sheila", 3.9, "Math", "Physics", "Astronomy", "Quantum Mechanics")
    );

    Stream<Student> ss =  roster.stream();
        ss.filter(s -> s.getGpa() > 3.0)
        .map(s -> s.getName() + " has grade " + s.getGpa())
        .forEach(System.out::println /* s -> System.out.println(s)*/);
    System.out.println("--------------------------");
    roster.stream()
//        ss
        .peek(s -> System.out.println(">> " + s))
        .filter(s -> s.getGpa() > 3.0)
        .flatMap(s -> s.getCourses().stream())
        .map(s -> s + " is being taken")
        .forEach(System.out::println);
    System.out.println("--------------------------");
    roster.stream()
        .peek(s -> System.out.println(">> " + s))
        .filter(s -> s.getGpa() > 3.0)
//        .forEach(System.out::println)
    ;
    System.out.println("--------------------------");
    Stream.iterate(1, x -> x + 2)
        .forEach(System.out::println);
  }
}
