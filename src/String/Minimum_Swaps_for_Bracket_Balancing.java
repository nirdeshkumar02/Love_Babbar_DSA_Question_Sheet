package String;
/*
You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets.
A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings.
We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps
necessary to make a string balanced.
Note - Strings S1 and S2 can be empty.
 */
public class Minimum_Swaps_for_Bracket_Balancing {
    public static void main(String[] args){
        String s = "[[][]]";
        int n = s.length();
        System.out.println(minNoSwaps(s));
    }

    private static int minNoSwaps(String s) {
        int close = 0;
        int open = 0;
        int fault = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                close++;
                fault = close - open;
            }
            else {
                open++;
                if(fault > 0){
                    ans += fault;
                }
                fault--;
            }
        }
        return ans;
    }
}
