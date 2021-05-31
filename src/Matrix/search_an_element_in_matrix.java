package Matrix;

public class search_an_element_in_matrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15,16}};
        int target = 11;
        System.out.println(searchElement_binarySearch(matrix, target));
        System.out.println(searchElement_bruteForce(matrix, target));
    }

    private static boolean searchElement_bruteForce(int[][] matrix, int target) {
        //   Time Complexity = O(mn)

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == target) return true;
//            }
//        }
//        return false;


        for (int[] rows : matrix) {
            for (int num : rows) {
                if (num == target) return true;
            }
        }
        return false;
    }


    private static boolean searchElement_binarySearch(int[][] matrix, int target) {
                //   Time Complexity = O(log(mn))
        if(matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int num = matrix[mid / cols][mid % cols];
            if(num == target) return true;
            else if(num < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
