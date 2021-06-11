package Searching_Sorting;

public class Kth_element_of_two_sorted_array {
    public static void main(String[] args){
        int arr1[] = {2, 3, 6, 7, 9};
        int n = arr1.length;
        int arr2[] = {1, 4, 8, 10};
        int m = arr2.length;
        int k = 5;
        System.out.println(kthElement(arr1, arr2, m, n, k));

    }

    private static int kthElement(int[] arr1, int[] arr2, int m, int n, int k) {
        int i=0,j=0,l=0;
        int ans[]=new int[n+m];
        while(i<n && j<m)
        {
            if(arr1[i]<arr2[j])
                ans[l]=arr1[i++];
            else
                ans[l]=arr2[j++];
            l++;
        }

        while(i<n)
            ans[l++]=arr1[i++];
        while(j<m)
            ans[l++]=arr2[j++];

        return ans[k-1];
    }
}
