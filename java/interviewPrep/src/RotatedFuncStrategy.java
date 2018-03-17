import java.util.Arrays;

public class RotatedFuncStrategy implements RotateStrategy {

    @Override
    public void rotateNumbers(int n, int d, int[] a) {
        Arrays.stream(a).skip(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s -> System.out.print(s + " "));
        Arrays.stream(a).limit(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s -> System.out.print(s + " "));
    }
}