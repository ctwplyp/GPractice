package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateStuff {
  public static <E> List<E> getByCriterion(
      Iterable<E> ls, Predicate<E> crit) {
    List<E> out = new ArrayList<>();
    for(E s : ls) {
      if (crit.test(s)) {
        out.add(s);
      }
    }
    return out;
  }

  public static <E, F> List<F> translate(Iterable<E> in, Function<E, F> op) {
    List<F> out = new ArrayList<>();
    for (E e : in) {
      F f = op.apply(e);
      out.add(f);
    }
    return out;
  }

  public static <E> void showAll(List<E> ls) {
    forEvery(ls, s -> System.out.println("> " + s));
    System.out.println("-----------------------");
  }

  public static <E> void forEvery(Iterable<E> ls, Consumer<E> op) {
    for (E s : ls) {
      op.accept(s);
    }
  }

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        Student.of("Fred", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Jim", 2.7, "Art", "Philosophy"),
        Student.of("Sheila", 3.9, "Math", "Physics", "Astronomy", "Quantum Mechanics")
    );

    showAll(roster);
    showAll(getByCriterion(roster, s -> s.getGpa() < 3.0));

    List<String> names = Arrays.asList("Fred", "Jim", "Sheila", "Alice");
    showAll(getByCriterion(names, x -> x.length() > 4));

    showAll(translate(names, s -> s.toUpperCase()));
    showAll(translate(names, String::toUpperCase));
    showAll(translate(names, s -> s.length()));
    showAll(translate(names, String::length));
  }
}
