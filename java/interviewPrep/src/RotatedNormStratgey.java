

public class RotatedNormStratgey implements RotateStrategy {

    @Override
    public void rotateNumbers(int n, int d, int[] a) {
        int[] b = new int[n];
        for (int i=0; i<n; i++){
            if (d+i>(n-1)){
                b[i]=a[(d+i)%n];
            } else b[i]=a[d+i];
        }
        for (int j=0;j<n;j++){
            System.out.print(b[j] + " ");
        }
    }
}