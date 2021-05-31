package Arrays;

public class Cyclically_rotate_an_array_by_one {
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5};
        int size = arr.length;
        rotateByOne(arr, size);
        printArray(arr, size);

    }

    private static void printArray(int[] arr, int n) {
        for(int element : arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    private static void rotateByOne(int[] arr, int n) {
        int last = arr[n-1];
        for(int i = n-2; i>=0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = last;
    }
}
