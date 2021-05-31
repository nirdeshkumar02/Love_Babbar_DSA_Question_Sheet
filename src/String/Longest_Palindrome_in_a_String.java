package String;
/*
    Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ]
    where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally,
    S is palindrome if reverse(S) = S. In case of conflict, return the substring which occurs first
    ( with the least starting index).
 */
public class Longest_Palindrome_in_a_String {
    public static void main(String[] args) {
        String S = "aaaabbaa";
        System.out.println(longestPalindromeString(S));

    }

    private static String longestPalindromeString(String s) {
        int maxsize=0;
        String longestString="";
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                String temp=s.substring(i,j+1);
                StringBuilder s1=new StringBuilder(temp);
                if(temp.equals(s1.reverse().toString()))
                {
                    if(temp.length()>maxsize)
                    {
                        maxsize=temp.length();
                        longestString=temp;
                    }
                }
            }
        }
        if(longestString.equals(""))
        {
            return s.charAt(0)+"";
        }
        return longestString;
    }
}
