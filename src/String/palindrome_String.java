package String;

public class palindrome_String {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int start = 0; int end = s.length()-1;
        while (start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
