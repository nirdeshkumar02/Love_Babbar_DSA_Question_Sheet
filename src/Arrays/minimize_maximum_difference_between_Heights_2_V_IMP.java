package Arrays;
import java.util.*;
/*
 Problem - Minimize the height //
 Description -
   Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of
   each tower either by increasing or decreasing them by K only once.
        Find out what could be the possible minimum difference of the height of shortest and longest towers after
        you have modified each tower.
        Note: Assume that height of the tower can be negative.
*/

public class minimize_maximum_difference_between_Heights_2_V_IMP {
    public static void main(String[] args ){
        int arr[] = {3, 9, 12, 16, 20};
        int n = arr.length;
        int k = 3;
        System.out.println(getMinMax(arr, n, k));
    }

    private static int getMinMax(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int min = arr[0]+k;
        int max = arr[n-1] - k;
        int result = arr[n-1] - arr[0];
        for(int i =1; i<=n-1; i++){
            max = Math.max(arr[i-1]+k, arr[n-1] - k);
            min = Math.min(arr[0]+k, arr[i]-k);
            result = Math.min(result, max-min);
        }
        return result;
    }
}
