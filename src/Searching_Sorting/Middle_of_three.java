package Searching_Sorting;

import java.util.*;

public class Middle_of_three {
    public static void main(String[] args) {
        int A = 978, B = 518, C = 300;
        System.out.println(middle(A,B,C));
    }

    private static int middle(int a, int b, int c) {
        int arr[] = new int[] {a,b,c};
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        return arr[mid];

    }
}
