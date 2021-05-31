package Arrays;

public class left_rotate_by_d_places {
    public static void main(String[] args){
        int arr[] = {10,5,30,15};
        int size = arr.length;
        int d = 3;
        leftRotate(arr, size, d);
        printArray(arr, size);
    }

    private static void printArray(int[] arr, int size) {
        for(int nums : arr){
            System.out.print(nums+" ");
        }
        System.out.println();
    }

    private static void leftRotate(int[] arr, int n, int d) {
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);

    }

    private static void reverse(int[] arr, int left, int right) {
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }
    }
}
