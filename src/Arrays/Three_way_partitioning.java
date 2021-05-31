package Arrays;

public class Three_way_partitioning {

    /*
        Given an array of size n and a range [a, b]. The task is to partition the array around the range such that
            array is divided into three parts.
                1) All elements smaller than a come first.
                2) All elements in range a to b come next.
                3) All elements greater than b appear in the end.
        The individual elements of three sets can appear in any order. You are required to return the modified array
     */
    public static void main(String[] args){
        int n = 5;
        int arr[] = {1, 2, 3, 3, 4};
        int a = 1; int b = 2;
        threeWayPartition( arr,  a,  b, n);
    }

    private static void threeWayPartition(int[] arr, int a, int b, int n) {
        int low=0,high=n-1;
        int i=0;

        while(i<=high)
        {
            if(arr[i]<a)
            {
                int temp=arr[low];
                arr[low]=arr[i];
                arr[i]=temp;
                low++;
                i++;
            }

            else if(arr[i]>b)
            {
                int temp=arr[high];
                arr[high]=arr[i];
                arr[i]=temp;
                high--;
            }
            else
                i++;
        }
        for (int num : arr) {
            System.out.print(num+ " ");
        }
        System.out.println();
    }
}
