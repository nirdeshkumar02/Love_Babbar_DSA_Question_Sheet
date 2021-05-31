package String;

public class Longest_Common_Subsequence {
    public static void main(String[] args){
       String str1 = "ABCDGH";
       String str2 = "AEDFHR";
        System.out.println(lcs(str1, str2));
    }

    private static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            for (int j = 1 ; j <=n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
