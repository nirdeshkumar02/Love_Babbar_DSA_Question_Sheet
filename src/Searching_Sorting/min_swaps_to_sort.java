package Searching_Sorting;
import java.util.*;

public class min_swaps_to_sort {
    public static void main(String[] args){
        int arr[] = {2,8,5,4};
        int n = arr.length;
        System.out.println(minSwaps(arr,n));
    }

    private static int minSwaps(int[] arr, int n) {
        int[] duplicateArr = new int[n];
        for(int i=0; i<n; i++){
            duplicateArr[i] = arr[i];
        }
        Arrays.sort(duplicateArr);
        int i=0;
        int count =0;
        while(i<n){

            if(arr[i]!=duplicateArr[i]){
                swap(arr,i,findIndex(duplicateArr, arr[i]));
                count++;
            }
            //if(arr[i]==duplicateArr[i]) i++;
            //swap(arr,i,findIndex(duplicateArr, arr[i]) );
            //count++;
            if(arr[i]==duplicateArr[i]) i++;
        }

        return count;
    }


    public static int findIndex(int arr[], int target){
        return Arrays.binarySearch(arr, target);
    }

    public static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}