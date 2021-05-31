package String;

public class Split_the_binary_string_into_substrings_with_equal_0s_and_1s {
    public static void main(String []args)
    {
        String str = "0111100010";
        int n = str.length();

        System.out.println(maxSubStr(str, n));
    }

    private static int maxSubStr(String str, int n) {
        int count0 = 0;
        int count1 = 0;
        int cnt=0;
        for (int i = 0; i < n; i++){
            if (str.charAt(i) == '0') count0++;
            else count1++;
            if(count0 == count1 ) cnt++;
        }
        if(count0 != count1) return -1;
        return cnt;
    }
}
