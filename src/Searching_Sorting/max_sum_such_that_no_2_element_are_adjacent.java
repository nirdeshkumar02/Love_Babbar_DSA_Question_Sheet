package Searching_Sorting;

public class max_sum_such_that_no_2_element_are_adjacent {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = {5,5,10,100,10,5};
        System.out.println(maxSum(arr, n));
        System.out.println(maxSumUsingDP(arr, n));
    }

    private static int maxSumUsingDP(int[] arr, int n) {
        if(n==0) return 0;
        int dp[] = new int[n];
        if(n>=1) dp[0] = arr[0];
        if(n>=2) dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i< n; i++){
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i - 1]);
        }
        return dp[n-1];
    }

    private static int maxSum(int[] arr, int n) {
        if(n<1) return 0;
        int include = arr[0];
        int exclude = 0;
        for(int i = 1; i<n; i++){
            int temp = include;
            include = exclude + arr[i];
            exclude = Math.max(temp, exclude);
        }
        return Math.max(include, exclude);
    }
}
