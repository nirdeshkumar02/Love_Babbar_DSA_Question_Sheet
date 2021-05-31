package Arrays;

import java.math.BigInteger;
import java.util.Scanner;

public class find_factorial_of_large_no {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. = ");
            int n=sc.nextInt();
            System.out.println(factorial(n));

        }


    private static BigInteger factorial(int N){
        BigInteger result=new BigInteger("1");

        for(int i=2;i<=N;i++){
            result=result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
