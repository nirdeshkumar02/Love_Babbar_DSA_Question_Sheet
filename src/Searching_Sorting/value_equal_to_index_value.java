package Searching_Sorting;

import java.util.ArrayList;

/*
Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its index value.
 */
public class value_equal_to_index_value {
    public static void main(String[] args) {
        int arr[] = {15, 2, 45, 12, 7};
        int n = arr.length;
        System.out.println(valueEqualtoIndex(arr,n));
    }

    static ArrayList<Integer> valueEqualtoIndex(int[] arr, int n) {

        ArrayList<Integer>list = new ArrayList<Integer>();
        for(int i =0; i<n; i++){
            if(arr[i]==i+1) list.add(i+1);
        }
        return list;
    }

}
