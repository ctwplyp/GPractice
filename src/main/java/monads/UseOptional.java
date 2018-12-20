package monads;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseOptional {
  public static void main(String[] args) {
    Map<String, String> names = new HashMap<>();
    names.put("Fred", "Jones");

    String firstName = "Fred";
    String lastName = names.get(firstName);
    String shout = lastName.toUpperCase();
    System.out.println(shout);

    Optional<Map<String, String>> opt = Optional.of(names);
    opt.map(m -> m.get("Freddy")) // NOT Optional.of(null) but Optional.empty()
        .map(String::toUpperCase)
        .ifPresent(System.out::println);
  }
}
