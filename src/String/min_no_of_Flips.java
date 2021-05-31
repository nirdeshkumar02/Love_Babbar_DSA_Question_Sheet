package String;

public class min_no_of_Flips {
    public static void main(String[] args){
        String s = "0001010111";
        System.out.println(minFlips(s));
        System.out.println(minFlip(s));
    }

    private static int minFlip(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i <n;i++){
            if(i%2==0 && s.charAt(i)=='0') count++;
            if(i%2==1 && s.charAt(i)=='1') count++;
        }
        return Math.min(count, n-count);
    }

    private static int minFlips(String s) {
        char ch[] = s.toCharArray();
        int n = s.length();
        int max1 =0;
        for (int i = 0; i <n; i++){
            if((i%2==0 && ch[i]=='0')||(i%2==1 && ch[i]=='1')) max1++;
        }
        return Math.min(max1,n-max1);
    }
}
