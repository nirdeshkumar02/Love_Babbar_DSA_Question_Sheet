package Arrays;

public class Sort_an_array_of_0s_1s_and_2s_without_sorting {
   public static void main(String[] args){
       int arr[]= {0,2,1,2,0};
       int size = arr.length;
       sort012(arr,size);
       printArray(arr,size);
   }

    private static void printArray(int[] arr, int n) {
        for (int num: arr) {
            System.out.print(num+","+" ");
        }
        System.out.println();
    }

    private static void sort012(int[] arr, int n) {
       int low=0, mid=0, high=n-1,swap;
       while(mid <= high){
           if(arr[mid] == 0){
               swap = arr[mid];
               arr[mid] = arr[low];
               arr[low] = swap;
               low++;
               mid++;
           }
           else if(arr[mid] == 2){
               swap = arr[mid];
               arr[mid] = arr[high];
               arr[high] = swap;
               high--;
           }
           else{
               mid++;
           }
       }
    }
}
