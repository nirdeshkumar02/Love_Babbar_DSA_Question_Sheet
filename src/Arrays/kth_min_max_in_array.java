package Arrays;

import java.util.*;
import java.lang.*;

public class kth_min_max_in_array {
        public static void main(String args[]) {
            int arr[] = {7, 10, 4, 20, 15};
            int k = 4 ;

            Pair minmax = getMinMax(arr, k);
            System.out.printf("\nMinimum element is %d", minmax.min);
            System.out.printf("\nMaximum element is %d", minmax.max);
        }

    private static Pair getMinMax(int[] arr, int k) {
            Pair minmax = new Pair();
            int n = arr.length;
            if(n==1){
                minmax.max = arr[0];
                minmax.min = arr[0];
                return minmax;
            }
            else{
                Arrays.sort(arr);
                for(int i = 0; i< n; i++){
                    System.out.println(arr[i]);
                }
                // It will sort the array in ascending order
                minmax.max = arr[n-k];
                minmax.min = arr[k-1];
            }
        return minmax;
    }


    private static class Pair{
            int min;
            int max;
    }
}
