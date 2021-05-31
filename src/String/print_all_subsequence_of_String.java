package String;

import java.util.*;

public class print_all_subsequence_of_String {
    public static void main(String[] args){
        String s = "abcd";
        findsubsequences(s, ""); // Calling a function
        System.out.println(al);
    }

    static List<String> al = new ArrayList<>();

    private static void findsubsequences(String s, String ans) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }

        // We add adding 1st character in string
        findsubsequences(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s.substring(1), ans);
    }
}
