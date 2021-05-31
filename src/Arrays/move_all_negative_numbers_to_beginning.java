package Arrays;

import java.util.Arrays;

public class move_all_negative_numbers_to_beginning {
    public static void main(String[] args){
        int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int size = arr.length;
        naive_rearrange(arr, size);
        printArray(arr,size);
        twoPointer_arrange(arr,size);
        printArray(arr,size);
        usingSorting(arr,size);
        printArray(arr,size);
    }

    private static void usingSorting(int[] arr, int n) {
        Arrays.sort(arr);
    }

    private static void twoPointer_arrange(int[] arr, int n) {
        int low = 0;
        int high = n-1;
        int temp;
        while(low <= high){
            if(arr[low] < 0 && arr[high] < 0 ){
                low++;
            }
            else if(arr[low] > 0 && arr[high] < 0){
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
            else if(arr[low] > 0 && arr[high] > 0){
                high --;
            }
            else{
                low++;
                high--;
            }
        }
    }

    private static void printArray(int[] arr, int n) {
        for (int nums: arr) {
            System.out.print(nums+" ");
        }
        System.out.println();
    }

    private static void naive_rearrange(int[] arr, int n) {
        int j = 0;
        int temp;
        for(int i =0; i< n; i++){
            if(arr[i] < 0){
                if(i != j){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

}
