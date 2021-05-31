package Arrays;

public class largest_sum_contiguous_subarray_or_KADANE_ALGO_V_IMP {
    public static void main(String[] args){
        int arr[] = {-1,-2,-3,-4};
        int size = arr.length;
        System.out.println(kadane_algo(arr, size));

    }

    private static int kadane_algo(int[] arr, int n) {
        int sum = arr[0];
        int maxEnding = arr[0];
        for(int i = 1; i < n; i++ ){
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            sum = Math.max(sum, maxEnding);
        }
        return sum;
    }
}
