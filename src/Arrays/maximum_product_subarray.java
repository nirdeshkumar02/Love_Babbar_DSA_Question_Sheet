package Arrays;

public class maximum_product_subarray {
    public static void main(String[] args) {
        int arr[] = {6, -3, -10, 0, 2};
        int N = arr.length;
        System.out.println(maxProduct(arr, N));
    }

    private static long maxProduct(int[] arr, int n) {
        int min = arr[0];
        int max = arr[0];
        int ans = arr[0];

        for(int i = 1; i< arr.length; i++){
            if(arr[i] < 0){
                int swap = min;
                min = max;
                max = swap;
            }

            max = Math.max(arr[i], max*arr[i]);
            min = Math.min(arr[i], min*arr[i]);

            ans = Math.max(max, ans);

        }
        return ans;
    }
}
