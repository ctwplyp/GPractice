package streamexamples;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStuff {
  public static Stream<String> gettext(String filename) {
    try {
      return Files.lines(Paths.get(filename));
    } catch (Throwable t) {
      System.out.println("OOOps..");
      throw new RuntimeException(t);
    }
  }

  public static void main(String[] args) {
    Stream.of("a.txt", "bx.txt", "c.txt")
        // open files for reading, get a Stream<String> from the lines of text
        .flatMap(n -> gettext(n))
        .forEach(System.out::println);
  }
}
