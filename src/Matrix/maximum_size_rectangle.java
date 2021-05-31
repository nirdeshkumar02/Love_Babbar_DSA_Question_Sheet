package Matrix;

import java.util.Stack;

public class maximum_size_rectangle {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int M[][] = {{0,1,1,0}, {1,1,1,1}, {1,1,1,1}, {1,1,0,0}};
        System.out.println(maxArea(M, m, n));
    }

    public static int maxArea(int M[][], int n, int m) {
        // add code here.
        int[] hist = new int[m];
        int res = 0;
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){

                hist[j] = (hist[j]+ M[i][j])* M[i][j];
            }

            res = Math.max(res, calArea(hist, m));

        }

        return res;
    }

    public static int calArea(int hist[], int n){

//         for(int i=0; i<n; i++){
// 			System.out.print(hist[i]+" ");
// 		}
// 		System.out.println();
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && hist[st.peek()]>= hist[i]){
                int top = st.pop();
                int curr = (st.isEmpty() ? i : i - st.peek() - 1 ) * hist[top];
                res = Math.max(res, curr);
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int top = st.pop();
            int curr = (st.isEmpty() ? n : n - st.peek() - 1 ) * hist[top];
            res = Math.max(res, curr);
        }

        return res;
    }
}