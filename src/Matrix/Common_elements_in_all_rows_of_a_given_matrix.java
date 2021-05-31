package Matrix;

import java.util.HashMap;
import java.util.Map;

public class Common_elements_in_all_rows_of_a_given_matrix {
    public static void main(String[] args)
    {
        int mat[][] = {{1, 2, 1, 4, 8}, {3, 7, 8, 5, 1}, {8, 7, 7, 3, 1}, {8, 1, 2, 7, 9}};

        printCommonElements(mat);
    }

    private static void printCommonElements(int[][] mat) {

         int M = 4;
         int N =5;

        Map<Integer,Integer> mp = new HashMap<>();

        // initalize 1st row elements with value 1
        for (int j = 0; j < N; j++)
            mp.put(mat[0][j],1);

        // traverse the matrix
        for (int i = 1; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // If element is present in the map and
                // is not duplicated in current row.
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i)
                {
                    // we increment count of the element
                    // in map by 1
                    mp.put(mat[i][j], i + 1);

                    // If this is last row
                    if (i == M - 1)
                        System.out.print(mat[i][j] + " ");
                }
            }
        }
    }
}
