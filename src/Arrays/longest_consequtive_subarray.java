package Arrays;
import java.util.*;
public class longest_consequtive_subarray {
    public static void main(String[] args){
        int arr[] = {2,6,1,9,4,5,3};
        int N = arr.length;
        System.out.println(longestSubsequence(arr, N));
    }

    private static int longestSubsequence(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }

        int count = 0;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i< n; i++){
            if(!set.contains(arr[i]-1)){
                int val = arr[i-1];
            }
            while (set.contains(arr[i])){
                count++;
                arr[i]++;
            }

            ans = Math.max(ans, count);
            count=0;
        }
        return ans;
    }
}
