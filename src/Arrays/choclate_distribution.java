package Arrays;
import java.util.*;

public class choclate_distribution {

    /*
   Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
   Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets
   among M students such that :
        1. Each student gets exactly one packet.
        2. The difference between maximum number of chocolates given to a student and minimum number of chocolates
            given to a student is minimum.
     */

    public static void main(String[] args){
        int N = 7;  // no of chocolate packet
        int M = 3;  // no. of students
        int A[] = {7, 3, 2, 4, 9, 12, 56};

        findMindiff(A,N,M);
//        System.out.println(findMindiff2(A,N,M));
    }

//    private static long findMindiff2(ArrayList<Long> a, long n, long m) {
//        Collections.sort(a);
//        long diff=Long.MAX_VALUE;
//
//        for(int i=0;i+m-1<n;i++)
//        {
//            long x=a.get((int)i);
//            long y=a.get((int)(i+m-1));
//            diff=Math.min(diff,y-x);
//
//        }
//        return diff;
//    }

    private static void findMindiff(int[] a, int n, int m) {
        Arrays.sort(a);
        int min=a[n-1]-a[0];
        for(int i=0;i+m-1<n;i++)
        {

            min=Math.min(min,a[i+m-1]-a[i]);

        }
        System.out.println(min);
    }
}
