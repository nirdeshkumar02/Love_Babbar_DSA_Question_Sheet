package String;

import java.util.Stack;

public class remove_cosequtive_characters {
    public static void main(String[] args){
        String s = "aaaccaaabbb";
        int n = s.length();
        System.out.println(removeConsequtive(s, n));
    }

    private static String removeConsequtive(String s, int n) {
        Stack<Character> st = new Stack<>();
            st.push(s.charAt(0));

            for(int i=1;i<n;i++){
                if(!st.isEmpty() && st.peek() != s.charAt(i))
                    st.push(s.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            return sb.reverse().toString();
    }
}
