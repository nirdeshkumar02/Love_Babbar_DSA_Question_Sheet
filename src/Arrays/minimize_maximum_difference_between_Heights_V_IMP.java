package Arrays;
// Minimize the height //
// Description - Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower
// either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
//Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.//

import java.lang.reflect.Array;
import java.util.Arrays;

public class minimize_maximum_difference_between_Heights_V_IMP {
    public static void main(String[] args){
        int arr[] = {3, 9, 12, 16, 20};
        int n = arr.length;
        int k = 3;
        System.out.println(getMinMax(arr, n, k));
    }

    private static int getMinMax(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int max_ele, min_ele;
        int ans = arr[n-1] - arr[0];
        for(int i = 1; i<= n-1; i++) {
            if (arr[i] >= k) {
                max_ele = Math.max(arr[i - 1] + k, arr[n - 1] - k);
                min_ele = Math.min(arr[0] + k, arr[i] - k);
                ans = Math.min(ans, max_ele - min_ele);
            }
        }
        return ans;
    }
}
