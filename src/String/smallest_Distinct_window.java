package String;

import java.util.HashMap;
import java.util.HashSet;

public class smallest_Distinct_window {
    public static void main(String[] args){
        String s = "AABBBCBBAC";
        System.out.println(sDw(s));
    }
    // return String //..
  private static String sDw(String s) {

       String ans = "";
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, j = -1;
        while(true){
            boolean f1 = false, f2 = false;
            while(i < s.length()-1 && map.size() < set.size()){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            while(j < i && map.size() == set.size()){
                f2 = true;
                String pAns = s.substring(j+1, i+1);
                if(ans.length() == 0 || pAns.length() < ans.length()){
                    ans = pAns;
                }
                j++;
                char ch = s.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else {
                    map.put(ch, map.get(ch) -1);
                }
            }
            if(f1 == false && f2 == false){
                break;
            }

        }
        return ans;
    }
}
