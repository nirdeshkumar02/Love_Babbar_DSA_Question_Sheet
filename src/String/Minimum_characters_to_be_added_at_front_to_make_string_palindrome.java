package String;

public class Minimum_characters_to_be_added_at_front_to_make_string_palindrome {
    public static void main(String[] args){
        String str = "AACECAAAA";;
        int cnt = 0;
        int flag = 0;

        // naive approach that takes o(n^2)

//        while (str.length() > 0) {
//            if (ispalindrome(str)) {
//                flag = 1;
//                break;
//            } else {
//                cnt++;
//                // erase the last element of the string
//                str = str.substring(0, str.length() - 1);
//            }
//        }
//        // print the number of insertion at front
//        if (flag == 1) {
//            System.out.println(cnt);
//        }

        // efficient approach using lps[] array
        System.out.println(getMinCharToAddedToMakeStringPalin(str));
    }

//    private static boolean ispalindrome(String str) {
//        int l = str.length();
//
//        for (int i = 0, j = l - 1; i <= j; i++, j--) {
//            if (str.charAt(i) != str.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 2nd method //

    static int getMinCharToAddedToMakeStringPalin(String str)
    {
        StringBuilder s = new StringBuilder();
        s.append(str);

        // Get concatenation of string, special character
        // and reverse string
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);

        // Get LPS array of this concatenated string
        int lps[] = computeLPSArray(s.toString());
        return str.length() - lps[s.length() - 1];
    }

    public static int[] computeLPSArray(String str)
    {
        int n = str.length();
        int lps[] = new int[n];
        int i = 1, len = 0;
        lps[0] = 0; // lps[0] is always 0

        while (i < n)
        {
            if (str.charAt(i) == str.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0)
                {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

