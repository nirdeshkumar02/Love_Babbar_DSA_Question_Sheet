package String;

public class Smallest_window_in_a_string_containing_all_the_characters_of_another_string {
    public static void main(String[] args){
        String s = "timetopractice";
        String p = "toc";
        System.out.println(smallestWindow(s,p));
    }

    private static String smallestWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 < len2) return "-1";
        int[] hashPat = new int[256];
        int[] hashString = new int[256];
        for (int i = 0; i < len2 ; i++){
            hashPat[t.charAt(i)]++;
        }
        int start =0, startIndex=-1, min = Integer.MAX_VALUE, count= 0;

        for (int j = 0; j < len1; j++){
            hashString[s.charAt(j)]++;
            if(hashPat[s.charAt(j)] != 0 && hashString[s.charAt(j)] <= hashPat[s.charAt(j)]){
                count++;
                if(count == len2){
                    while(hashPat[s.charAt(start)] == 0 || hashString[s.charAt(start)] > hashPat[s.charAt(start)]){
                        if(hashString[s.charAt(start)] > hashPat[s.charAt(start)]){
                            hashString[s.charAt(start)]--;
                            start++;
                        }
                    }
                    int len_window = j-start+1;
                    if(min > len_window){
                        min = len_window;
                        startIndex = start;
                    }
                }
            }
        }
        if(startIndex == -1)return("-1");
        else
            return(s.substring(startIndex,startIndex+min));

    }
}
