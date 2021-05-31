package Matrix;

public class Rotate_a_matrix_by_90_degree {
    public static void main (String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        // solution 1 - The Approach is to rotate the given matrix two times,
        // first time with respect to the Main diagonal, next time rotate the resultant matrix with respect to
        // the middle column, Consider the following illustration to have a clear insight into it.
        rotate(arr);
        printMatrix(arr);

        // solution 2 - 
        rotate90Clockwise(arr);
    }

    private static void rotate90Clockwise(int[][] arr) {
        int n=arr.length;
        for (int j = 0; j < n; j++)
        {
            for (int i = n - 1; i >= 0; i--)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    private static void printMatrix(int[][] arr) {
        int n=arr.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotate(int[][] arr) {
        int n=arr.length;

        // first rotation
        // with respect to main diagonal
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<i;++j)
            {
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        // Second rotation
        // with respect to middle column
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n/2;++j)
            {
                int temp =arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1]=temp;
            }
        }
    }
}
