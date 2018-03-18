public class RotateContext {
   private RotateStrategy rs;

    public void setRotateStrategy(String strategy){
        if (strategy =="Func") {
            rs = new RotatedFuncStrategy();
        } else {
            rs = new RotatedNormStrategy();
        }
    }
    public void rotate(int n, int d, int[] a){
        rs.rotateNumbers(n, d, a);
    }
}