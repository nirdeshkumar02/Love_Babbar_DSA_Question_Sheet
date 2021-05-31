package Arrays;

import java.util.Arrays;

public class merge_two_arrays_without_extra_space {
    public static void main(String[] args){
        int arr1[] = {1, 3, 5, 7};
        int n = 4;
        int arr2[] = {0, 2, 6, 8, 9};
        int m = 5;
        merge(arr1, arr2, n, m );
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n; i++) {
            str.append(arr1[i] + " ");
        }
        for (int i = 0; i < m; i++) {
            str.append(arr2[i] + " ");
        }
        System.out.println(str);
    }

    private static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i = n-1, j = 0;
        while(i >= 0 && j< m){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
