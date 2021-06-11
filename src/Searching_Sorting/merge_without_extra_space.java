package Searching_Sorting;
import java.util.*;

public class merge_without_extra_space {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int m = arr1.length;
        int arr2[] = {0, 2, 6, 8, 9};
        int n = arr2.length;
        mergeArrays(arr1, arr2,m,n);
    }

    private static void mergeArrays(int[] arr1, int[] arr2, int m, int n) {
        int i = 0; int j =0;
        while(i<m && j<n){
            if(arr1[i] < arr2[j]){
                System.out.println(arr1[i]+" ");
                i++;
            }
            else{
                System.out.println(arr2[j]+" ");
                j++;
            }
        }
        while(i<m){
            System.out.println(arr1[i]+" ");
            i++;
        }
        while(j<n){
            System.out.println(arr2[j]+" ");
            j++;
        }


//        int i=n-1,j=0;
//        while(i>=0 && j<m) {
//            if(arr1[i]>arr2[j])
//            {
//                int temp=arr1[i];
//                arr1[i]=arr2[j];
//                arr2[j]=temp;
//            }
//            i--;
//            j++;
//        }
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
    }
}
