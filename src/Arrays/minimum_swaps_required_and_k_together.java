package Arrays;

public class minimum_swaps_required_and_k_together {

    /*
        Given an array of n positive integers and a number k.
        Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
     */

    public static void main(String[] args){
        int arr[ ] = {2, 7, 9, 5, 8, 7, 4};
        int k = 6;
        int n = arr.length;
        System.out.println(minSwaps(arr, n, k));

    }

    private static int minSwaps(int[] arr, int n, int k) {

        /*
            explanation - To bring elements 2, 1, 3 together, swap element '5' with '3'
                such that final array will be- arr[] = {2, 1, 3, 6, 5}
         */

        int good=0,bad=0;
        for(int i=0;i<n;i++)
            if(arr[i]<=k)
                good++;

        for(int i=0;i<good;i++)
            if(arr[i]>k)
                bad++;

        int ans=bad;

        for(int i=0,j=good;j<n;j++,i++)
        {
            if(arr[i]>k)
                bad--;
            if(arr[j]>k)
                bad++;
            ans=Math.min(ans,bad);
        }


        return ans;

    }
}
