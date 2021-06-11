package Searching_Sorting;
import java.util.*;
/*
Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product
of all the elements of nums except nums[i].
 */
public class product_array {
    public static void main(String[] args){
       int arr[] = {10, 3, 5, 6, 2};
       int n = arr.length;
        System.out.println(productArray(arr,n));
    }

    private static long[] productArray(int[] arr, int n) {
        long p[]=new long[n];
        Arrays.fill(p,1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                    p[(int)i]*=arr[(int)j];
            }
        }
        return p;
    }
}
