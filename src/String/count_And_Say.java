package String;

public class count_And_Say {
    public static void main(String[] args){
        int n = 7;
        System.out.println(countAndSay(n));
    }
    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String res = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i< res.length(); i++){
            int count = 1;
            while((i+1)<res.length() && res.charAt(i)==res.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(res.charAt(i));
        }
        return sb.toString();
    }
}
