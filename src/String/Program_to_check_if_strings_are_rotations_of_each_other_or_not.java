package String;

/*
        Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)


Algorithm: areRotations(str1, str2)

    1. Create a temp string and store concatenation of str1 to
       str1 in temp.
                          temp = str1.str1
    2. If str2 is a substring of temp then str1 and str2 are
       rotations of each other.

    Example:
                     str1 = "ABACD"
                     str2 = "CDABA"

     temp = str1.str1 = "ABACDABACD"
     Since str2 is a substring of temp, str1 and str2 are
     rotations of each other.

 */
public class Program_to_check_if_strings_are_rotations_of_each_other_or_not {
    public static void main(String[] args){
        String str1 = "ABACD";
        String str2 = "CDABA";

        if (areRotations(str1, str2)) //  Using Substring
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf("Strings are not rotations of each other");

        System.out.println(isRotation(str1, str2) ? "1" : "0"); // using KMP
    }

    private static boolean areRotations(String str1, String str2) {
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
    }

    //  Using KMP algorithm’s lps --------------------

    private static boolean isRotation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if(n != m) return false;
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[n];

        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to n-1
        while (i < n) {
            if (str1.charAt(i) == str2.charAt(len)) {
                lps[i] = ++len;
                ++i;
            }
            else {
                if (len == 0) {
                    lps[i] = 0;
                    ++i;
                }
                else {
                    len = lps[len - 1];
                }
            }
        }

        i = 0;

        // match from that rotating point
        for (int k = lps[n - 1]; k < m; ++k) {
            if (str2.charAt(k) != str1.charAt(i++))
                return false;
        }
        return true;

    }

}
