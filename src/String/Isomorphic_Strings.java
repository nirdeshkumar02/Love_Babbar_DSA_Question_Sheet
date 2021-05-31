package String;
/*
Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1
to every character of str2 while preserving the order.
Note: All occurrences of every character in ‘str1’ should map to the same character in ‘str2’
 */
public class Isomorphic_Strings {
    public static void main(String[] args){
        String str1 = "aab";
        String str2 = "xxy";
        System.out.println(areIsomorphic(str1, str2));
    }

    private static boolean areIsomorphic(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int map1[] = new int[256];
        int map2[] = new int[256];

        if(n!=m) return false;
        for(int i=0; i<n; i++){
            if(map1[str1.charAt(i)] != map2[str2.charAt(i)]){
                return false;
            }
            map1[str1.charAt(i)] = i+1;
            map2[str2.charAt(i)] = i+1;
        }
        return true;
    }
}
