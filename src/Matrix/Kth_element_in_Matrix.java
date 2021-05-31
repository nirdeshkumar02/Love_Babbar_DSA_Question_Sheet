package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kth_element_in_Matrix {
    /*
        Given a N x N matrix, where every row and column is sorted in non-decreasing order.
        Find the kth smallest element in the matrix.
     */
    public static void main(String[] args) {
        int N = 4;
        int mat[][] = {{10, 20, 30, 40},{15, 25, 35, 45},{24, 29, 37, 48},{32, 33, 39, 50}};
        int K = 7;
        System.out.println(kthElement(mat, N, K));
    }

    private static int kthElement(int[][] mat, int n, int k) {
        List<Integer> list = new ArrayList<>();
        for( int i =0; i< n; i++ ){
            for(int j = 0; j<n; j++){
                list.add((Integer)mat[i][j]);
            }
        }
        Collections.sort(list);
        return (list.get(k-1));
    }
}
