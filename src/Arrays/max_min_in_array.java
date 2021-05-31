package Arrays;

import java.util.Arrays;

public class max_min_in_array {
    public static void main(String args[]) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }

    private static Pair getMinMax(int[] arr, int n) {
        Pair minmax = new Pair();
        int i;

        if(n == 1){
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        Arrays.sort(arr);
        minmax.max = arr[n-1];
        minmax.min = arr[0];

        // or you can use this //

//        if(arr[0] > arr[1]){
//            minmax.max = arr[0];
//            minmax.min = arr[1];
//        }
//        else{
//            minmax.max = arr[1];
//            minmax.min = arr[0];
//        }
//
//        for(i =2; i< arr.length; i++){
//            if(arr[i] > minmax.max ){
//                minmax.max = arr[i];
//            }
//            else if(arr[i] < minmax.min){
//                minmax.min = arr[i];
//            }
//        }

        return minmax;
    }
    private static class Pair{
        int max;
         int min;
    }




}

