package Searching_Sorting;
import java.util.*;

public class Count_triplets_with_sum_smaller_than_X {
    public static void main(String[] args) {
        int arr[] = {-2, 0, 1, 3};
        int sum = 2;
        int n = arr.length;
        System.out.println(count(arr, sum, n));
    }

    private static int count(int[] arr, int sum, int n) {
        Arrays.sort(arr);
        int i, j, k , count = 0;
        for(i = 0; i< n-2; i++){
            j = i + 1;
            k = n-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]<sum){
                    count += k-j;
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return count;
    }
}
