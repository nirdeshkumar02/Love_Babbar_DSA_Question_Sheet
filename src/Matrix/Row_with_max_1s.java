package Matrix;

public class Row_with_max_1s {
    /*
        Given a boolean 2D array of n x m dimensions where each row is sorted.
        Find the 0-based index of the first row that has the maximum number of 1's.
     */
    public static void main(String[] args) {
        int N = 4 , M = 4;
        int arr[][] = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(arr, N, M));
    }

    private static int rowWithMax1s(int[][] arr, int n, int m) {
        int rowWithMaxOnes=-1;
        int maxOnes=0;

        int rowIndex = 0;
        int colIndex = m-1;

        while (rowIndex < n && colIndex >=0){
            if(arr[rowIndex][colIndex] == 1){
                rowWithMaxOnes = rowIndex;
                maxOnes++;
                colIndex--;
            }
            else{
                rowIndex++;
            }
        }
        return rowWithMaxOnes;

    }
}
