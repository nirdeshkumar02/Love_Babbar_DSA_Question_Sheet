package Matrix;
/*
Given an n x n matrix mat[n][n] of integers,
find the maximum value of mat(c, d) – mat(a, b) over all choices of indexes such that both c > a and d > b.
 */

public class Find_a_specific_pair_in_Matrix {
    public static void main(String[] args) {
        int N = 5;
        int mat[][] = {{1, 2, -1, -4, -20}, {-8, -3, 4, 2, 1}, {3, 8, 6, 1, 3}, {-4, -1, 1, 7, -6},
                {0, -4, 10, -5, 1}};

        System.out.print("Maximum Value is " + findMaxValue(N, mat));
    }

    private static int findMaxValue(int n, int[][] mat) {
        int maxValue = Integer.MIN_VALUE;
        int maxArray[][] = new int[n][n];

        // last element
        maxArray[n - 1][n - 1] = mat[n - 1][n - 1];

        int maxV = mat[n - 1][n - 1];
        // for the last row
        for (int i = n - 2; i >= 0; i--) {
            if (mat[n - 1][i] > maxV)
                maxV = mat[n - 1][i];
            maxArray[n - 1][i] = maxV;
        }

        // for the last col
        for (int i = n - 2; i >= 0; i--) {
            if (mat[i][n - 1] > maxV)
                maxV = mat[i][n - 1];
            maxArray[i][n - 1] = maxV;
        }

        // rest of matrix from bottom
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // Update maxValue
                if (maxArray[i + 1][j + 1] - mat[i][j] > maxValue)
                    maxValue = maxArray[i + 1][j + 1] - mat[i][j];

                // set maxArr (i, j)
                maxArray[i][j] = Math.max(mat[i][j],
                        Math.max(maxArray[i][j + 1],
                                maxArray[i + 1][j]));
            }
        }

        return maxValue;
    }
}
