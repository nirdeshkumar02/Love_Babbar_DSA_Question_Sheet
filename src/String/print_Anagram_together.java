package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class print_Anagram_together {
    public static void main(String[] args){
        String words[] = {"act","god","cat","dog","tac"};
        System.out.println(Anagrams(words));
    }
    public static List<List<String>> Anagrams(String[] str) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String i: str) {
            char[] ch = i.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if(hm.containsKey(s)){
                hm.get(s).add(i);
            }
            else{
                List<String> l = new ArrayList<>();
                l.add(i);
                ans.add(l);
                hm.put(s,l);

            }
        }

        return ans;
    }
}
