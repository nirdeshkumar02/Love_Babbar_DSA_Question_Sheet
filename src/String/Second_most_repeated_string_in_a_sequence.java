package String;

import java.util.HashMap;

/*
Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.
Note: No two strings are the second most repeated, there will be always a single string.
 */
public class Second_most_repeated_string_in_a_sequence {
    public static void main(String[] args){
       String arr[] = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
       int N = arr.length;
        System.out.println(secFrequent(arr,N));
    }

    private static String secFrequent(String[] arr, int N) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        HashMap<String, Integer>map = new HashMap<>();
        for(int i = 0; i<N; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            int cnt = map.get(arr[i]);
            if(cnt>max) max = cnt;
            else if (cnt>secMax) secMax = cnt;
        }
        String ans = "";
        for(int i = 0; i<N; i++){
            if(map.get(arr[i])==secMax){
                ans=arr[i];
                break;
            }
        }
        return ans;

    }
}
