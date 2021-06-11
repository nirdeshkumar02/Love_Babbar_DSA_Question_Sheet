package Searching_Sorting;

public class searching_an_element_neighbour_difference_is_k {
    public static void main(String[] args){
        int arr[] = { 2, 4, 5, 7, 7, 6 };
        int x = 6;
        int k = 2;
        int n = arr.length;

        System.out.println("Element " + x + " is present at index " + search(arr, n, x, k));
    }

    private static int search(int[] arr, int n, int x, int k) {
        int i = 0;
        for(i = 0; i<n; i++){
            if(arr[i] == x)
                return i;
            i = i + Math.max(1, Math.abs(arr[i]-x)/k);
        }
        return -1;
    }
}
