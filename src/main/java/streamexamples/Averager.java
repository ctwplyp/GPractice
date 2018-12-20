package streamexamples;

import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

class Average {
  private long count;
  private double sum;

  public Average() {}

  public void include(double d) {
    sum += d;
    count++;
  }

  public void merge(Average other) {
    sum += other.sum;
    count += other.count;
  }

  public OptionalDouble get() {
    if (count > 0) return OptionalDouble.of(sum/count);
    else return OptionalDouble.empty();
  }
}

public class Averager {
  public static void main(String[] args) {
//    Stream<Double> // NONONONONONO Boxing/unboxing!!!
    DoubleStream.generate( // primitive :)
        () -> ThreadLocalRandom.current().nextDouble(-Math.PI, +Math.PI))
        .limit(1_000_000_000)
        .collect(
            Average::new,
            Average::include,
            Average::merge)
//        .collect(
//            () -> new Average(),
//            (b, i) -> b.include(i),
//            (b, b1) -> b.merge(b1))
    .get()
    .ifPresent(a -> System.out.println("Average is " + a));
    ;
  }
}
