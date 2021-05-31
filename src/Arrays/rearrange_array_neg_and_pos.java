package Arrays;

import java.io.*;
import java.lang.*;
import java.util.*;

// Time complexity = O(n*logn)

public class rearrange_array_neg_and_pos {

    /*

    public static void main(String[] args)
            throws java.lang.Exception
    {
        // Given array
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = arr.length;

        int neg = 0, pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                neg++;
            else
                pos++;
        }
        // Sort the array
        Arrays.sort(arr);

        if (neg <= pos) {
            fill1(arr, neg, pos);
        }
        else {
            // reverse the array in this condition
            reverse(arr, n);
            fill2(arr, neg, pos);
        }
        print(arr, n);
    }


    static void fill1(int a[], int neg, int pos)
    {
        if (neg % 2 == 1) {
            for (int i = 1; i < neg; i += 2) {
                int c = a[i];
                int d = a[i + neg];
                int temp = c;
                a[i] = d;
                a[i + neg] = temp;
            }
        }
        else {
            for (int i = 1; i <= neg; i += 2) {
                int c = a[i];
                int d = a[i + neg - 1];
                int temp = c;
                a[i] = d;
                a[i + neg - 1] = temp;
            }
        }
    }
    // function which works in the condition when number of
    // negative numbers are greater than positive numbers
    static void fill2(int a[], int neg, int pos)
    {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2) {
                int c = a[i];
                int d = a[i + pos];
                int temp = c;
                a[i] = d;
                a[i + pos] = temp;
            }
        }
        else {
            for (int i = 1; i <= pos; i += 2) {
                int c = a[i];
                int d = a[i + pos - 1];
                int temp = c;
                a[i] = d;
                a[i + pos - 1] = temp;
            }
        }
    }
    static void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
    static void print(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

     */


    public static void main(String[] args)
    {
        int arr[] = {2, 3, -4, -1, 6, -9};

        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("Rearranged array is ");
        printArray(arr, n);
    }

    static void rearrange(int arr[], int n)
    {
        int i = 0, j = n - 1;

        // shift all negative values to the end
        while (i < j)
        {
            while(i <= n - 1 && arr[i] > 0)
                i += 1;
            while (j >= 0 && arr[j] < 0)
                j -= 1;
            if (i < j)
                swap(arr, i,j);
        }

        // i has index of leftmost negative element
        if (i == 0 || i == n)
            return;

        // start with first positive
        // element at index 0

        // Rearrange array in alternating positive &
        // negative items
        int k = 0;
        while (k < n && i < n)
        {
            // swap next positive element
            // at even position
            // from next negative element.
            swap(arr,k,i);
            i = i + 1;
            k = k + 2;
        }
    }

    // Utility function to print an array
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }


    static void swap(int arr[], int index1, int index2)
    {
        int c = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=c;
    }

}
