import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static void printRotated(int n, int d, int[] a){
        //System.arraycopy(a, 0, a, 1, position);
        Arrays.stream(a).skip(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s ->System.out.print(s));
        Arrays.stream(a).limit(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s ->System.out.print(s));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        printRotated(n, d, a);

    }
}