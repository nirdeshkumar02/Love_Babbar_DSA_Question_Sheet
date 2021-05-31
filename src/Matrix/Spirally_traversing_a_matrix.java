package Matrix;

public class Spirally_traversing_a_matrix {
    public static void main(String[] args){
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15,16}};
        int R = 4;
        int C = 4;
        printSpiral(matrix,R,C);
    }

    private static void printSpiral(int[][] a, int r, int c) {
        int left = 0, right = c-1, top = 0, bottom = r-1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++)
                System.out.print(a[top][i]+" ");

            top++;
            for(int i=top;i<=bottom;i++)
                System.out.print(a[i][right]+" ");

            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--)
                    System.out.print(a[bottom][i]+" ");

                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--)
                    System.out.print(a[i][left]+" ");

                left++;
            }


        }

    }
}
