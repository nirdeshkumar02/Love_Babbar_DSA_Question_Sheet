package Searching_Sorting;

public class Majority_Elements {
    public static void main(String[] args){
        int arr[] = {3,1,3,3,2};
        int n = arr.length;
        System.out.println(majorityElement(arr, n));
    }
    static int majorityElement(int arr[], int n)
    {
        int count=1,res=0;
        for(int i=1;i<n;i++){
            if(arr[res]==arr[i])
                count++;
            else
                count--;
            if(count==0){
                count=1;
                res=i;
            }
        }
        count=0;
        for(int i=0;i<n;i++)
            if(arr[res]==arr[i])
                count++;
        if(count>n/2)
            return arr[res];
        else
            return -1;

    }
}
