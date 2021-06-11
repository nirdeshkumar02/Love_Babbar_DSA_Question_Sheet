package Searching_Sorting;
import java.util.*;
public class find_pair_with_give_difference {
    public static void main(String[] args) {
        int arr[] = {5, 20, 3, 2, 5, 80};
        int n = 6;
        int d = 78;
        System.out.println(CheckPair(arr, n, d));
    }

    private static boolean CheckPair(int[] arr, int n, int d) {
        Arrays.sort(arr);
        int i = 0; int j = 1;
        while(i<n && j<n){
            if(arr[j]-arr[i] == d && i != j) return true;
            else if(arr[j] - arr[i] > d) i++;
            else j++;
        }
        return false;

    }
}
