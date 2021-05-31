package Arrays;

import java.util.ArrayList;

public class find_common_elements_in_3_sorted_array {
    public static void main(String[] args){
        int A[] = {1, 5, 10, 20, 40, 80};
        int B[] = {6, 7, 20, 80, 100};
        int C[] = {3, 4, 15, 20, 30, 70, 80, 120};
        int n1 = A.length;
        int n2 = B.length;
        int n3 = C.length;
        System.out.println(commonElements(A, B, C, n1, n2, n3));

    }
    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int last = Integer.MIN_VALUE;

        while (i < n1 && j < n2 && k < n3)
        {
            if (A[i] == B[j] && A[i] == C[k] && A[i] != last)
            {
                res.add (A[i]);
                last = A[i];
                i++;
                j++;
                k++;
            }
            else if (Math.min (A[i], Math.min(B[j], C[k])) == A[i]) i++;
            else if (Math.min (A[i], Math.min(B[j], C[k])) == B[j]) j++;
            else k++;
        }
        return res;
    }
}
