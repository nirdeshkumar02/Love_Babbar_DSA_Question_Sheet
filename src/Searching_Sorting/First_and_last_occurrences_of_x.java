package Searching_Sorting;

import java.util.ArrayList;

/*
Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find
indexes of first and last occurrences of an element x in the given array.
 */
public class First_and_last_occurrences_of_x {
    public static void main(String[] args) {
        int n = 9, x = 5;
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        find(arr, n, x);
    }
     public static void find(int[] arr, int n, int x ){
        ArrayList al = new ArrayList();
        for(int i = 0; i<n; i++){
            al.add(arr[i]);
        }
        int first = al.indexOf(x);
        int last = al.lastIndexOf(x);

        if(first != -1 && last != -1){
            System.out.println(first+" "+last);
        }
        else{
            System.out.println("-1");
        }
     }
}
