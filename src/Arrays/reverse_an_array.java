package Arrays;

public class reverse_an_array {
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        reverseArray(arr, 0, 5);
        System.out.print("Reversed array is \n");
        printArray(arr, 6);
    }

    private static void reverseArray(int[] arr, int left, int end) {
        int temp =0;
        while(left < end){
            temp = arr[left];
            arr[left] = arr[end];
            arr[end] = temp;
            left++;
            end--;
        }

    }

    private static void printArray(int[] arr, int size) {
        for(int i = 0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
