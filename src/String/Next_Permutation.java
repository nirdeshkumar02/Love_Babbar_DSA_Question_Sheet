package String;

import java.util.Arrays;

/*
    Implement the next permutation, which rearranges the list of numbers into Lexicographically
    next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the
    lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.
 */
public class Next_Permutation {
    public static void main(String[] args){
        int a[] = {1, 2, 3, 6, 5, 4};
        int n = a.length;
        Large(a,n);
    }

    private static void Large(int[] a, int n) {
        int i = n-2;
        while(i>=0) {
            if(a[i]<a[i+1]) {
                break;
            }
            i--;
        }
        if(i==-1) {
            Arrays.sort(a);
        }
        else {

            int k = n-1;
            while(a[k]<a[i]) {
                k--;
            }

            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            Arrays.sort(a, i+1, n);
        }

        for(int j=0;j<n;j++) {
            System.out.print(a[j]+" ");
        }

        System.out.println();

    }
}



