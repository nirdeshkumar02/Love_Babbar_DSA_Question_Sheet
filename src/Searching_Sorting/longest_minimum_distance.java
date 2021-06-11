package Searching_Sorting;
import java.util.*;

public class longest_minimum_distance {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 4, 9 };
        int n = arr.length;
        int k = 3;
        System.out.print(largestMinDist(arr, n, k));
    }

    private static int largestMinDist(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int res = -1;
        int left = arr[0];
        int right = arr[n-1]-arr[0];
        while (left < right){
            int mid = (left + right) / 2;
            if (isFeasible(mid, arr, n, k)) {
                // Change value of variable max to
                // mid if all elements can be
                // successfully placed
                res = Math.max(res, mid);
                left = mid + 1;
            }

            // If not possible to place k elements,
            // search for lower distance
            else
                right = mid;
        }

        return res;
    }

    private static boolean isFeasible(int mid, int[] arr, int n, int k) {
        int pos = arr[0];

        // Initialize count of elements placed.
        int elements = 1;

        // Try placing k elements with minimum
        // distance mid.
        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= mid) {
                // Place next element if its
                // distance from the previously
                // placed element is greater
                // than current mid
                pos = arr[i];
                elements++;

                // Return if all elements are
                // placed successfully
                if (elements == k)
                    return true;
            }
        }
        return false;
    }
}


