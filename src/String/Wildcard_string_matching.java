package String;
/*
Given two strings wild and pattern where wild string may contain wild card characters and
pattern string is a normal string. Determine if the two strings match.
The following are the allowed wild card characters in first string :-
 */
public class Wildcard_string_matching {
    public static void main(String[] args){
        String wild = "ge?ks";
        String pattern = "geeks";
        System.out.println(match(wild, pattern));
    }

    private static boolean match(String s1, String s2) {
        s1 = s1.replace("*",".*");
        s1 = s1.replace("?",".");

        if(s2.matches(s1)) {
            return true;
        } else {
            return false;
        }


    }
}
