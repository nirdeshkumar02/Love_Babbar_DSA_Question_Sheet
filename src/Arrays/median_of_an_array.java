package Arrays;
import java.util.*;
public class median_of_an_array {
    public static void main(String[] args){
        int arr[] = {10,20,30,40,50,60};
        int n = arr.length;
        System.out.println(findMedian(arr, n));
    }

    private static int findMedian(int[] v, int n) {
        Arrays.sort(v);
        int mid;
        if(n%2==0)
        {
            mid=n/2;
            int avg=(v[mid]+v[mid-1])/2;
            return avg;
        }
        else
            mid=n/2;
        return v[mid];
    }
}
