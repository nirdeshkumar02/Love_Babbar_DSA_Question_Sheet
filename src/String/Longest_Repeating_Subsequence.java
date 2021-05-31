package String;

public class Longest_Repeating_Subsequence {
    public static void main(String[] args){
        String str = "axxxy";
        System.out.println(LongestRepeatingSubsequence(str));
    }

    private static int LongestRepeatingSubsequence(String str) {
        /*
        String rev = str;
        int len = str.length();
        int[][] t = new int[len+1][len+1];
        for(int i = 0; i < len ; i++) {
            for(int j = 0; j < len ; j++) {
                if(i==0||j==0) {
                    t[i][j]=0;
                }
            }
        }
        for(int i = 1 ; i <= len ; i++) {
            for(int j = 1 ; j <= len; j++) {
                if(str.charAt(i-1)==rev.charAt(j-1) && i!=j) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[len][len];
         */
        int n = str.length();
        if( n == 0 ){
            return 0;
        }
        int dp[][] = new int[n+1][n+1];

        for( int i =1; i<=n ; i++){
            char x = str.charAt(i-1);


            for( int j = 1; j <=n ; j++){
                char y = str.charAt(j-1);
                if( x == y && i!= j ){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],
                            Math.max( dp[i-1][j-1], dp[i][j-1] ));

                }
            }
        }
        return dp[n][n];
    }
}
