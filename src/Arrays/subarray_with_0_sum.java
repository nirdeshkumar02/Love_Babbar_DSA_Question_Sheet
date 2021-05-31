package Arrays;

import java.util.HashSet;
import java.util.Set;

public class subarray_with_0_sum {
    public static void main(String[] args){
        int arr[] = {4, 2, -3, 1, 6};
        int n = arr.length;

        System.out.println(subArray(arr, n));
    }

    private static boolean subArray(int[] arr, int n) {
        int sum = 0;
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i< n; i++){
            sum += arr[i];

            if(sum == 0 || arr[i] == 0 || map.contains(sum)){
                return true;
            }
            map.add(sum);
        }
        return false;
    }
}
