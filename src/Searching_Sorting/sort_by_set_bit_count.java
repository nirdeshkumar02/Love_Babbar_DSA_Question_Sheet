package Searching_Sorting;
import java.util.*;

public class sort_by_set_bit_count {
    public static void main(String[] args) {
        Integer arr[] = {3,1,5};
        int n = arr.length;
        setCount(arr,n);

    }

    private static void setCount(Integer[] arr, int n) {
        if(n>1){
            Arrays.sort(arr, (a,b) -> Integer.compare(Integer.bitCount(b),Integer.bitCount(a)) );
            System.out.println(arr);
        }

    }
}
