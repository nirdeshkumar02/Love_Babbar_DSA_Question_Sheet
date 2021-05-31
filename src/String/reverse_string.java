package String;

public class reverse_string {
    public static void main(String[] args){
        String str = "Geeks";
        System.out.println(reverseString(str));
    }

    private static String reverseString(String str) {
        char s[] = str.toCharArray();
        String reverse = "";
        for(int i =s.length-1; i>=0; i--){
            reverse += s[i];
        }
        return reverse;
    }
}
