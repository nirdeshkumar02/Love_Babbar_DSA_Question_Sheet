package Arrays;

public class Smallest_subarray_with_sum_greater_than_x {
    public static void main(String[] args){
        long A[] = {1, 4, 45, 6, 0, 19};
        long x  =  51;
        long n = A.length;
        System.out.println(sb(A,x,n));
    }

    private static long sb(long[] a, long x, long n) {
        long currSum = 0, minLength = n + 1;
        int startIndex = 0, endIndex = 0;
        while (endIndex < n)
        {

            while (currSum <= x && endIndex < n)
                currSum += a[endIndex++];

            while (currSum > x && startIndex < endIndex)
            {
                if (endIndex - startIndex < minLength)
                    minLength = endIndex - startIndex;

                currSum -= a[startIndex++];
            }
        }
        return minLength;
    }
}
