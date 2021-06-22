package Searching_Sorting;
import java.util.*;

public class allocate_min_no_of_pages {
    public static void main(String[] args) {
        int n = 4;
        int a[] = {12,34,67,90};
        int m = 2;
        System.out.println(findPage(a,n,m));
    }

    private static int findPage(int[] a, int n, int m) {
        if(n<m) return -1;
        int sum = 0;
        for(int i = 0; i<n; i++) sum += a[i];
        int start = 0;
        int end = sum;
        int ans = Integer.MAX_VALUE;
        while(start<end){
            int mid = (start + end)/2;
            if(isPossible(a,n,m,mid)){
                ans = Math.min(ans, mid);
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;


    }

    private static boolean isPossible(int[] a, int n, int m, int curMin) {
        int studentsRequired = 1;
        int curSum = 0;
        for (int i = 0; i < n; i++) {

            if (a[i] > curMin) return false;

            if (curSum + a[i] > curMin) {

                studentsRequired++;
                curSum = a[i];
                if (studentsRequired > m) return false;
            }
            else {
                curSum += a[i];
            }
        }
        return true;
    }
}
