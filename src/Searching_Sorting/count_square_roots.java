package Searching_Sorting;

public class count_square_roots {
    public static void main(String[] args) {
        int N = 9;
        System.out.println(countSquare(N));

    }

    private static int countSquare(int n) {
        int count = 0;
        for (int i = 1; i*i<n; i++){
            if((i*i)<n){
                count += 1;
            }
        }
        return count;
    }
}
