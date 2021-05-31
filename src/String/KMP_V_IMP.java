package String;

public class KMP_V_IMP {
    public static void main(String[] args){
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }

    private static void KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int i = 0;
        int j = 0;
        // create lps[] that will hold the longest prefix suffix values for pattern
        int lps[] = new int[m];
        countLPS(pat, m , lps);
        while(i<n){
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                System.out.println("Found pattern at index "+ (i-j));
                j = lps[j-1];
            }
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    private static void countLPS(String pat, int m, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i<m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
