package Matrix;

import java.util.Arrays;

public class print_element_in_Sorted_matrix {
    public static void main(String[] args) {
        int N=4;
        int mat[][] = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48}, {32,33,39,50}};
        sortMatrix(mat, N);
    }
    public static void sortMatrix(int a[][],int n){
        int temp[] = new int[n*n];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[k++]=a[i][j];
            }
        }
        Arrays.sort(temp);
        for(int i=0;i<temp.length;i++){
            System.out.print(temp[i]+" ");
        }
    }
}
