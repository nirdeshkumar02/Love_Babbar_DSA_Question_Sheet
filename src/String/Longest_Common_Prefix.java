package String;

public class Longest_Common_Prefix {
    public static void main(String[] args){
        String str[] = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(str));
    }

    private static String longestCommonPrefix(String[] str) {
        String s = str[0];
        for(int i=1; i<str.length; i++){
            for(int j=s.length(); j>=0; j--)
                if(str[i].startsWith(s.substring(0,j))){s = s.substring(0,j); break;}
        }
        return s;
    }
}
