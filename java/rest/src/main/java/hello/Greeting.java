package hello;

import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return fizzBuzz8();
        //return content;
    }

    public static String fizzBuzz8() {
       // String[] answer = new String[100];
        return  IntStream.range(1,100)
                .mapToObj( n -> n % 3 == 0 ?
                        ( n % 5 == 0 ? "FizzBuzz" : "Fizz") :
                        ( n % 5 == 0 ? "Buzz" :n))
                .map(n -> n.toString()).collect(Collectors.joining(","));

    }
}