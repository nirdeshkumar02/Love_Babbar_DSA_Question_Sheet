package String;

import java.util.Stack;

public class Parenthesis_Checker {
    public static void main(String[] args){
        String x = "([])";
        System.out.println(ispar(x));
    }

    private static boolean ispar(String x) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i< x.length(); i++){
            if(x.charAt(i) == '{' || x.charAt(i) == '[' || x.charAt(i) == '('){
                s.push(x.charAt(i));
            }
            else if(x.charAt(i) == '}' || x.charAt(i) == ']' || x.charAt(i) == ')'){
                if(s.isEmpty() == true && !compare(s.peek(), x.charAt(i))){
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }
        if(s.isEmpty() == true) return true;
        else
            return false;
    }

    private static boolean compare(char b, char c) {
        if(b == '{' && c == '}') return true;
        if(b == '[' && c == ']') return true;
        if(b == '(' && c == ')') return true;
        return false;
    }
}
