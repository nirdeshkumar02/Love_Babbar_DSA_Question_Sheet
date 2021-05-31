package Arrays;

import java.util.HashMap;

public class Count_pairs_with_given_sum {
    // Title - "Given an array of N integers, and an integer K,
    // find the number of pairs of elements in the array whose sum is equal to K."

    public static void main (String[] args){
        int arr[] = {1, 5, 7, 1};
        int K = 6;
        int n = arr.length;
        System.out.println("The solution with naive is = " + getPairCountNaive(arr,n,K));
        System.out.println("The solution with map 1st is = "+ getPairCountMap(arr,n, K));
        System.out.println("The solution with map 2nd is = "+ getPairCountMap2(arr,n, K));
    }

    private static int getPairCountMap2(int[] arr, int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int c = 0;
        for( int i: arr){
            int x = k - i;
            if( map.containsKey(x) ){
                c+= map.get(x);
            }
            map.put(i, map.getOrDefault(i,0)+1);
        }
        return c;
    }

    private static int getPairCountMap(int[] arr, int n, int k) {
        int sum = 0;
        HashMap<Integer, Integer> output = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
            int rem = k - arr[i];
            if(output.containsKey(rem)){
                int count = output.get(rem);
                for(int j = 0; j<count; j++){
                    sum += 1;
                }
            }

            if(output.containsKey(arr[i])){
                output.put(arr[i], output.get(arr[i]+1));
            }
            else{
                output.put(arr[i], 1);
            }

        }
        return sum;
    }

    private static int getPairCountNaive(int[] arr, int n, int k) {
        int count = 0;
        for(int i = 0; i< n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i]+ arr[j] == k){
                    count++;
                }
            }
        }
        return count;
    }
}
