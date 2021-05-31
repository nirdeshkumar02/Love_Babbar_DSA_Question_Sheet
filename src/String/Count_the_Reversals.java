package String;

import java.util.Stack;

/*
    Given a string S consisting of only opening and closing curly brackets '{' and '}',
    find out the minimum number of reversals required to convert the string into a balanced expression.
    A reversal means changing '{' to '}' or vice-versa.
 */
public class Count_the_Reversals {
    public static void main(String[] args){
        String s = "{{}{{{}{{}}{{";
        System.out.println(bracket(s) );
    }

    private static int bracket(String str) {
//        int ob = 0;
//        int cb =0;
//        Stack<Character> stack = new Stack<Character>();
//        for(int i = 0; i< str.length(); i++){
//            char cc = str.charAt(i);
//            if(cc == '{'){
//                stack.push(cc);
//            }
//            else{
//                if(!stack.isEmpty() && stack.peek() == '{'){
//                    stack.pop();
//                }
//                else{
//                    stack.push(cc);
//                }
//            }
//        }
//        while(!stack.isEmpty()){
//            if(stack.pop() == '{'){
//                ob++;
//            }
//            else{
//                cb++;
//            }
//        }
//        if((ob%2==0 && cb%2 != 0) || (ob%2 != 0 && cb%2 ==0)){
//            return -1;
//        }
//        else if(ob % 2 == 0 && cb %2 == 0 ){
//            return ob/2 + cb/2;
//        }
//        else{
//            return ob/2 + cb/2 +2;
//        }

        // 2nd way //

        int len = str.length();
        if(len%2 !=0){

            return -1;
        }
        Stack<Character> S = new Stack<Character>();

        for(int i =0; i<len; i++){
            char c = str.charAt(i);
            if(c == '}' && !S.empty()){
                if(S.peek()=='{')
                    S.pop();
                else
                    S.push(c);
            }else
                S.push(c);
        }

        int reduceLenght = S.size();
        int n =0;
        while(!S.empty() && S.peek() == '{'){
            S.pop();
            n++;
        }
        int ans = (reduceLenght/2 + n%2);
        return ans;


    }
}
