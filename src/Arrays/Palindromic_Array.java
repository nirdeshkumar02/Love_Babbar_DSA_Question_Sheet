package Arrays;

public class Palindromic_Array {
    public static void main(String[] args){
        int arr[] = {111, 222, 333, 444 ,555};
        int n = arr.length;
        System.out.println(palinArray(arr));
    }
    public static int palinArray(int[] a)
    {
        for (int arr : a)
        {
            int temp=arr;
            int reverse=0;
            while(arr>0)
            {
                int rem =arr%10;
                reverse =(reverse*10)+rem;
                arr=arr/10;
            }
            if(temp==reverse)
                continue;
            else
                return 0;


        }
        return 1;
    }
}
