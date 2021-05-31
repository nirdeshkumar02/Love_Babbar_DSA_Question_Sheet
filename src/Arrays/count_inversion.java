package Arrays;

public class count_inversion {
    public static void main(String[] args){
        long N = 5;
        long arr[] = {2, 3, 4, 5, 6};
        System.out.println(inversionCount(arr, N));
    }

    private static long inversionCount(long[] arr, long N) {
        long count =0;
        long temp[] = new long[(int)N];
        count = merge(arr,temp,0, N-1);
        return count;
    }

    private static long merge(long[] arr, long[] temp, int left, long right) {
        long mid, count =0;
        if(left < right){
            mid=(left+right)/2;
            count = merge(arr,temp, left, mid);
            count = count + merge (arr, temp, (int) (mid + 1), right);
            count = count + mergeSort(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeSort(long[] arr, long[] temp, long left, long mid, long right) {
        long count = 0;
        long i = left;
        long j = mid;
        long k = left;

        while(i <= mid-1 && j <= right){
            if(arr[(int)i] <= arr[(int)j]){
                temp[(int)k++] = arr[(int)i++];
            }
            else{
                temp[(int)k++] = arr[(int)j++];
                count = count + (mid - i);
            }
        }

        while(i <= mid-1){
            temp[(int)k++] = arr[(int)i++];
        }
        while(j <= right){
            temp[(int)k++] = arr[(int)j++];
        }
        for( i=left;i<=right;i++){
            arr[(int)i]=temp[(int)i];
        }
        return count;
    }
}
