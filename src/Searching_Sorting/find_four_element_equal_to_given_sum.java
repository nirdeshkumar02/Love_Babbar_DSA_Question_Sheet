package Searching_Sorting;

import java.util.*;

public class find_four_element_equal_to_given_sum {
    public static void main(String[] args){
         int k = 3;
        int arr[] = {0,0,2,1,1};
        int n = arr.length;
        System.out.println(fourSum(arr,n, k));
    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        HashSet<String> set  = new HashSet<String>();
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int l=j+1, r=n-1;

                while(l<r){
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    String s = arr[i] + " " + arr[j] + " " + arr[l] + " " + arr[r];
                    if(sum == k  && !set.contains(s)){
                        set.add(s);
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[l]);
                        al.add(arr[r]);
                        ans.add(al);
                    }
                    if(sum < k){
                        l+=1;
                    }else{
                        r-=1;
                    }
                }
            }
        }
        return ans;
    }
    }

