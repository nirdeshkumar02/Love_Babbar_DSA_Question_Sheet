package String;
/*
Boyer Moore is a combination of the following two approaches.
1) Bad Character Heuristic
2) Good Suffix Heuristic
 */

public class Boyer_Moore_Algo {

    static final int NO_OF_CHARS = 256;

    public static void main(String[] args){
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        badCharHeuristicSearch(txt, pat);
        GoodSuffixHeuristicSearch(txt, pat);
    }

    // 2nd Approach - Good Suffix Heuristic

    private static void GoodSuffixHeuristicSearch(char[] txt, char[] pat) {
        int s = 0, j;
        int m = pat.length;
        int n = txt.length;
        int shift[] = new int[m+1];
        int bpos[] = new int[m+1];
        for(int i = 0; i < m+1; i++){
            shift[i] = 0;
        }
        //do preprocessing
        preprocess_strong_suffix(shift, bpos, pat, m);
        preprocess_case2(shift, bpos, pat, m);

        while(s <= n-m){
            j= m-1;
            while(j >= 0 && pat[j] == txt[s+j])
                j--;
            if (j < 0)
            {
                System.out.printf("pattern occurs at shift = %d\n", s);
                s += shift[0];
            }
            else{
                s += shift[j + 1];
            }
        }
    }

    private static void preprocess_case2(int[] shift, int[] bpos, char[] pat, int m) {
        int i , j;
        j = bpos[0];
        for(i = 0; i <= m; i++){
            if(shift[i] == 0)
                shift[i] = j;
            if (i == j)
                j = bpos[j];
        }
    }

    private static void preprocess_strong_suffix(int[] shift, int[] bpos, char[] pat, int m) {
        int i = m, j = m+1;
        bpos[i] = j;
        while(i>0){
            while(j<=m && pat[i-1] != pat[j-1]){
                if(shift[j] == 0){
                    shift[j] = j-1;
                }
                j= bpos[j];
            }
            i--; j--;
            bpos[i] = j;
        }
    }

    // Case 2 - Bad Character Heuristic

    static void badCharHeuristicSearch( char txt[],  char pat[])
    {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

      /* Fill the bad character array by calling
         the preprocessing function badCharHeuristic()
         for given pattern */
        badCharHeuristic(pat, m, badchar);

        int s = 0;  // s is shift of the pattern with
        // respect to text
        //there are n-m+1 potential allignments
        while(s <= (n - m))
        {
            int j = m-1;

          /* Keep reducing index j of pattern while
             characters of pattern and text are
             matching at this shift s */
            while(j >= 0 && pat[j] == txt[s+j])
                j--;

          /* If the pattern is present at current
             shift, then index j will become -1 after
             the above loop */
            if (j < 0)
            {
                System.out.println("Patterns occur at shift = " + s);

              /* Shift the pattern so that the next
                 character in text aligns with the last
                 occurrence of it in pattern.
                 The condition s+m < n is necessary for
                 the case when pattern occurs at the end
                 of text */
                //txt[s+m] is character after the pattern in text
                s += (s+m < n)? m-badchar[txt[s+m]] : 1;

            }

            else
              /* Shift the pattern so that the bad character
                 in text aligns with the last occurrence of
                 it in pattern. The max function is used to
                 make sure that we get a positive shift.
                 We may get a negative shift if the last
                 occurrence  of bad character in pattern
                 is on the right side of the current
                 character. */
                s += max(1, j - badchar[txt[s+j]]);
        }
    }

    private static int max (int a, int b) { return (a > b)? a: b; }

    static void badCharHeuristic( char []str, int size,int badchar[])
    {

        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        // Fill the actual value of last occurrence
        // of a character (indeces of table are ascii and values are index of occurence)
        for (int i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }
}
