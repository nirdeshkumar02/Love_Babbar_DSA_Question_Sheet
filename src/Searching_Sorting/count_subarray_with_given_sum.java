package Searching_Sorting;

import java.util.*;

public class count_subarray_with_given_sum {
    public static void main(String[] args){
        int arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
        int n = arr.length;
        System.out.println(countSubarray(arr,n));
    }

    private static int countSubarray(int[] arr, int n) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int sum=0,count=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0)
                count++;
            if(hm.containsKey(sum)){
                count+=hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            }
            else
                hm.put(sum,1);
        }
        return count;
    }
}
