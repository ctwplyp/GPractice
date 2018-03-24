import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static void printRotatedFunc(int n, int d, int[] a) {
        Arrays.stream(a).skip(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s -> System.out.print(s + " "));
        Arrays.stream(a).limit(d).mapToObj(i -> ((Integer) i).toString())
                .forEach(s -> System.out.print(s + " "));


    }
    public static boolean checkArray(int[] arr, int n){
        return gcd(arr[0],arr[1])==gcd(arr[2],arr[3]);
    }
    public static int gcd(int a, int b){
        if (b==0)
            return a;
        return gcd(b, a%b);
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
    static public Map<String, Integer> toMap(String a) {
        return new HashMap<String, Integer>();
    }

    static Map<Integer, List<Integer>> addToList(Map<Integer, List<Integer>> hm, Integer firstElement, Integer secondElement) {

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        if (hm.containsKey(firstElement)) {
            firstList = hm.get(firstElement);
            if (!firstList.contains(secondElement)) {
                firstList.add(secondElement);
                secondList.add(firstElement);
            }
        } else {
            firstList.add(secondElement);
            secondList.add(firstElement);
        }
        hm.put(firstElement, firstList);
        hm.put(secondElement, secondList);
        return hm;
    }
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start>=nums.length)
            return (target==0);
        if (groupSum(start+1,nums,target-nums[start]))
            return true;
        if(groupSum(start+1,nums,target))
            return true;
        return false;
    }
    static int minimumAbsoluteDifference(int n, int[] arr) {
        int minDiff = Math.abs(arr[0]-arr[1]);
        for (int i=0;i<n+1;i++){
            for(int j=i+1;j<n;j++){
                System.out.println(arr[i] + " " +arr[j] );
                if (minDiff> (Math.abs(arr[i]-arr[j]))) {
                    minDiff = Math.abs(arr[i]-arr[j]);
                }
            }
        }
        return minDiff;
    }
    static int[] oddArray(int l, int r){
        boolean lOdd=(l%2==1);

        boolean rOdd=(r%2==1);
        if (!lOdd)
            l++;
        if(!rOdd)
            r--;
        int sizeOfArray = (r-l)/2+1;

        int[] answer = new int[sizeOfArray];
        for (int i=0;i<sizeOfArray;i++){
                answer[i]=l+2*i;
        }
        return answer;
    }
    public static int[] oddArrayStream(int a, int b){
        return IntStream.rangeClosed(a,b).filter(n->n%2==1).toArray();
    }
    public static int[] oddArrayIterate(int a, int b){
        return IntStream.iterate(a, n->n+1)
                .limit(b-a+1).filter(m->m%2==1).toArray();
    }



  /*  public static void main(String[] args) {
        int[] answer=oddArrayIterate(5,11);
        Arrays.stream(answer).mapToObj(i->(Integer) i).forEach(j->System.out.println(j));
        int[] answer4=oddArrayIterate(5,13);
        Arrays.stream(answer4).mapToObj(i->(Integer) i).forEach(j->System.out.println(j));
       // int [] answer2=oddArray(6,10);
       // Arrays.stream(answer2).mapToObj(i->(Integer) i).forEach(j->System.out.println(j));
       // int [] answer3=oddArray(5,10);
       // Arrays.stream(answer3).mapToObj(i->(Integer) i).forEach(j->System.out.println(j));

    }*?


    static int[] maxSubarray(int[] arr) {
        int total=0;
        int max =arr[0];
        for (int i=0; i<arr.length;i++){
            int currentSum=0;
            if (arr[i]>0)
                total = total+arr[i];
            for (int j=i;j<arr.length;j++)
            {
                currentSum=currentSum+arr[j];
                if (currentSum>max){
                    max=currentSum;
                }
            }
        }
        int[] answer =new int[2];
        answer[0]=total;
        answer[1]=max;
        return answer;

    }

        static int minimumAbsoluteSortDifference(int n, int[] arr) {
            Arrays.sort(arr);
            int minDiff=Integer.MAX_VALUE;
            for (int i=0;i<n-1;i++) {
                if (minDiff > Math.abs(arr[i] - arr[i + 1])) {
                    minDiff = Math.abs(arr[i] - arr[i + 1]);
                }
            }
            return minDiff;
        }*/
    public class Pair{
        public int a,b;
        Pair(int num1, int num2){
            a=num1;
            b=num2;
        }
        public String whoIsBigger(){
            if (a>b){
                return "ALICE";
            } if (a<b){
                return "BOB";
            }
            return "";
        }
    }
    /*
     * Complete the solve function below.
     */
    int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
        Pair[] dataAlice = {new Solution.Pair(a0, b0), new Pair(a1,b1), new Pair(a2,b2)};
        int scoreAlice=0;
        int scoreBob=0;
        scoreAlice = Arrays.stream(dataAlice).mapToInt(d ->d.whoIsBigger()=="ALICE"?1:0 ).sum();
        scoreBob = Arrays.stream(dataAlice).mapToInt(d ->d.whoIsBigger()=="BOB"?1:0 ).sum();
        return new int[]{scoreAlice, scoreBob};

     /*   int aliceScore=0;
        int bobScore = 0;
        if(1==compare(a0,b0)){
            aliceScore++;
        } else if (-1== compare(a0, b0)){
            bobScore++;
        }
        if(1==compare(a1,b1)){
            aliceScore++;
        } else if (-1== compare(a1, b1)){
            bobScore++;
        }
        if(1==compare(a2,b2)){
            aliceScore++;
        } else if (-1== compare(a2, b2)){
            bobScore++;
        }*/
       /* int answer = a0>b0?1:a0<b0?-1:0;
        if (answer ==1){

        }
        answer = (a0>b0)?1:a0<b0?-1:0;
        if (answer==1)
            aliceScore++;
        else if (answer ==-1)
            bobScore++;
        answer = (a1>b1)?1:a1<b1?-1:0;
        if (answer==1)
            aliceScore++;
        else if (answer ==-1)
            bobScore++;
        answer = (a2>b2)?1:a2<b2?-1:0;
        if (answer==1)
            aliceScore++;
        else if (answer ==-1)
            bobScore++;*/
       /* aliceScore = ((a0>b0)?1:0)+ ((a1>b1)?1:0)+ ((a2>b2)?1:0) ;
        bobScore = ((a0<b0)?1:0)+ ((a1<b1)?1:0)+ ((a2<b2)?1:0) ;*/
        //return new int[]{scoreAlice, scoreBob};

    }
    static int compare(int firstNum, int secondNum){
        int answer = firstNum-secondNum;
        if (answer>0){
            return 1;
        } else if (answer==0){
            return 0;
        } else return -1;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int a0 =5;

        int a1 =7;

        int a2 =9;

        int b0 = 10;

        int b1 = 7;

        int b2 = 3;
        Solution s= new Solution();

        int[] result = s.solve(a0, a1, a2, b0, b1, b2);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.print(" ");
            }
        }

       // bw.newLine();

        //bw.close();
    }
/*
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = minimumAbsoluteSortDifference(n, arr);
            System.out.println(result);
            in.close();
        }
/*
 public static boolean checkArray(int[] arr, int n){
        return gcd(arr[0],arr[1])==gcd(arr[2],arr[3]);
    }
    public static int gcd(int a, int b){
        if (b==0)
            return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][4];

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                 arr[row][column] = in.nextInt();
            }
        }
        //Solution s= new Solution();
       for(int[] a:arr){
        if (checkArray(a, n))
            System.out.println("YES");
        else System.out.println("NO");
        }
 */
  /*  public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = maxSubarray(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
   /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }

/*
    public static void main(String[] args) {
        String s = "abcd";
        String s2 = "bcde";
        int nc = 4;
        int mr = 5;
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        addToList(hm, 3,1);
        addToList(hm, 3,4);
        addToList(hm, 2,4);
        addToList(hm, 2,3);
        addToList(hm, 4,1);
        for (int i =0; i<nc;i++){
            List<Integer> firstElement = hm.get(i);
            List<Integer> possibleAnswer = new ArrayList<Integer>();
            for (int j=0; j<firstElement.size();j++)
                while(hm.containsKey(firstElement)){
                    possibleAnswer.add(firstElement);

                }

        }




      //  Map<String, Long> map= Arrays.stream(s.split(""))
        //        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        //Map<String, Integer> map2=Arrays.stream(s2.split(""))
          //      .collect(Collectors.groupingBy(c -> c, (Integer)Long.valueOf(Collectors.counting())));



        /*int sum=0;
        for(String key: map.keySet()){
            if (map2.containsKey(key)){
                sum=sum+Math.abs(Long.valueOf(map.get(key)-map2.get(key));
            } else sum=sum+Long.valueOf(map.get(key))
        }


        /*   Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        RotateContext rc = new RotateContext();
        rc.setRotateStrategy("Func");
        rc.rotate(n, d, a);
        */
    //   RotateStrategy rotatedStrategy = new RotatedFuncStrategy();
    //  rotatedStrategy.rotateNumbers(n,d,a);

    // printRotatedFunc(n, d, a);
}