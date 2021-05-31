package Matrix;
import java.util.*;
public class median_in_row_wise_sorted_matrix {
    public static void main(String[] args){
       int R = 3, C = 3;
       int M[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(median(M, R, C));
    }
    private static int median(int matrix[][], int r, int c) {
        int[] arr=new int[r*c];
        int m=r*c/2;
        int k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[k]=matrix[i][j];
                k++;
            }
        }
        Arrays.sort(arr);
        return arr[m];
    }
}
