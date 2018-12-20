package streamexamples;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface ExFunction<E,F> {
  F apply(E e) throws Throwable;
}

class Either<E> {
  private E data;
  private Throwable problem;

  private Either() {}

  public static <E> Either<E> success(E data) {
    Either<E> self = new Either<E>();
    self.data = data;
    return self;
  }

  public boolean isSuccess() {
    return data != null;
  }

  public static <E> Either<E> failure(Throwable t) {
    Either<E> self = new Either<E>();
    self.problem = t;
    return self;
  }

  public void ifProblem(Consumer<Throwable> op) {
    if (problem != null) {
      op.accept(problem);
    }
  }

  public E get() {
    if (data != null) return data;
    throw new IllegalStateException();
  }

  public static <E, F> Function<E, Either<F>> wrap(ExFunction<E, F> op) {
    return e -> {
      try {
        return Either.success(op.apply(e));
      } catch (Throwable t) {
        return Either.failure(t);
      }
    };
  }
}

public class FileStuffEither {
  public static void main(String[] args) {
    Stream.of("a.txt", "bx.txt", "c.txt")
        // open files for reading, get a Stream<String> from the lines of text
        .map(Either.wrap(n -> Files.lines(Paths.get(n))))
        .peek(e -> e.ifProblem(p -> System.out.println("PROBLEM: " + p.getMessage())))
        .filter(Either::isSuccess)
        .flatMap(Either::get)
        .forEach(System.out::println);
  }
}
