/*


package String;

import java.util.ArrayList;
import java.util.HashSet;

public class Word_Break {
    public static void main(String[] args){
        String A = "ilike";
        ArrayList<String> B = new ArrayList<String>({"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"});
        System.out.println(wordBreak(A, B));
    }

    private static int wordBreak(String A, ArrayList<String> B) {
        boolean[] t = new boolean[A.length()+1];
        t[0] = true;
        HashSet<String> hset = new HashSet<String>();
        for(int i = 0; i < B.size(); i++) {
            hset.add(B.get(i));
        }
        for(int i = 1; i <= A.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(hset.contains(A.substring(j,i)) && t[j]) {
                    t[i] = true;
                    break;
                }
            }
        }
        if (t[A.length()]) {
            return 1;
        } else {
            return 0;
        }

    }
}
 */

