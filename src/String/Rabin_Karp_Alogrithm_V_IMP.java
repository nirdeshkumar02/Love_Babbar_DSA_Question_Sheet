package String;

public class Rabin_Karp_Alogrithm_V_IMP {
    public static void main(String[] args){
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // Select a prime no.
        Search(txt, pat, q);

    }
        private static final int d = 256;
    private static void Search(String txt, String pat, int q) {
        int m = pat.length();
        int n = txt.length();
        int i,j;
        int p=0, t = 0; // hash value of pat and txt
        int h = 1;

        // calculating the value of h
        for(i = 0; i<m-1; i++){
            h = (h*d)%q;
        }

        // calculate the hash value of pat and txt
        for(i = 0; i<m; i++){
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }


        for(i = 0; i< n-m; i++){
            if(p == t){
                for(j = 0; j<m; j++){
                    if(txt.charAt(i+j) != pat.charAt(j)){
                        break;
                    }
                }
                if(j==m) System.out.println("pattern found at index " + i);
            }

            if ( i < n-m )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+m))%q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }

        }
    }

