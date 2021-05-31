package String;
/*
Given two strings s and t. Find the minimum number of operations that need to be performed on str1
    to convert it to str2. The possible operations are:
        1. Insert
        2. Remove
        3. Replace
 */
public class Edit_Distance_V_IMP {
    public static void main(String[] args){
        String s = "geek";
        String t = "gesek";
        System.out.println(editDistance(s,t));
    }
    public static int editDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int i = 0; i <=m; i++) dp[0][i] = i;

        for(int i=1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
            }
        }
        return dp[n][m];
    }
}
