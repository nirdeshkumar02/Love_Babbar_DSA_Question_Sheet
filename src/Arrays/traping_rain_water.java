package Arrays;

public class traping_rain_water {
    public static void main(String[] args){
        int arr[] = {6,9,9};
        int n = arr.length;
        System.out.println(trappingWater(arr,n));
    }

    private static int trappingWater(int[] arr, int n) {
        int res = 0;
        int Lmax[] = new int[n];
        int Rmax[] = new int[n];

        Lmax[0] = arr[0];
        for(int i = 1; i< n; i++){
            Lmax[i] = Math.max(Lmax[i-1], arr[i]);
        }

        Rmax[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            Rmax[i] = Math.max(Rmax[i+1], arr[i]);
        }

        for(int i = 0; i<n; i++){
            res += Math.min(Lmax[i], Rmax[i]) - arr[i];
        }
        return res;
    }
}
