import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {
    private static void printRotatedFunc(int n, int d, int[] a) {
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

    public static void main(String[] args) {
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