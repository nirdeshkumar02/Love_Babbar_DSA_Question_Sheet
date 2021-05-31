package Searching_Sorting;
import java.util.*;
public class find_missing_and_repeating_number {
    public static void main(String[] args) {
        int arr[] = {2, 2};
        int n = arr.length;
        System.out.println(missingAndRepeating(arr, n));
        System.out.println(missingAndRepeatingUsingHashSet(arr, n));
        System.out.println(missingAndRepeatingUsingAbsoluteValue(arr, n));
    }

    private static int[] missingAndRepeatingUsingAbsoluteValue(int[] arr, int n) {
        int[] ans = new int[2];
        int i;
        for (i = 0; i < n; i++) {
            System.out.println(Math.abs(arr[i]));
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                ans[0] = abs_val;
        }
        for (i = 0; i < n; i++) {
            if (arr[i] > 0) ans[1] = i + 1;
        }
        return ans;
    }
    // using hashSet //

    private static int[] missingAndRepeatingUsingHashSet(int[] arr, int n) {
        Set<Integer> set = new HashSet<Integer>();
        int ans[] = {0,0};

        for (int i = 0; i<n; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }
            else{
                ans[0] = arr[i];
            }
        }

        for(int num = 1; num<=n; num++){
            if(!set.contains(num)){
                ans[1] = num;
            }
        }
        return ans;
    }

    // using array //
    private static int[] missingAndRepeating(int[] arr, int n) {
        int ans[] = new int[n + 1];

        Arrays.fill(ans, 0);
        ans[0] = 1;
        for (int i = 0; i < n; i++) {
            ans[arr[i]]++;
        }

        int final_ans[] = new int[2];
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == 0)
                final_ans[1] = i;
            if (ans[i] >= 2)
                final_ans[0] = i;
        }
        return final_ans;
    }


}
