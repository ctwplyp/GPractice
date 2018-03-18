import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution  {
    private static void printRotatedFunc(int n, int d, int[] a){
        Arrays.stream(a).skip(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s -> System.out.print(s + " "));
        Arrays.stream(a).limit(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s -> System.out.print(s + " "));


    }
   /* private static void printRotatedReg(int n, int d, int[] a) {
        int[] b = new int[n];
        for (int i=0; i<n; i++){
            if (d+i>(n-1)){
                b[i]=a[(d+i)%n];
            } else b[i]=a[d+i];
        }
        for (int j=0;j<n;j++){
            System.out.print(b[j] + " ");
        }
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        RotateContext rc = new RotateContext();
        rc.setRotateStrategy("Func");
        rc.rotate(n, d, a);
            //   RotateStrategy rotatedStrategy = new RotatedFuncStrategy();
      //  rotatedStrategy.rotateNumbers(n,d,a);

       // printRotatedFunc(n, d, a);

    }
}