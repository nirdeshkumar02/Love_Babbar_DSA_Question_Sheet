package Arrays;

import java.util.HashMap;
import java.util.Map;

public class find_n_by_k_occurence_of_element {
    public static void main(String[] args){
        int a[] =  { 1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1 };
        int n = 12;
        int k = 4;
        moreThanN_K(a, n, k);
    }

    private static void moreThanN_K(int[] a, int n, int k) {

        int x = n/k;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<n; i++){
            if(!map.containsKey(a[i])){
                map.put(a[i], 1);
            }
            else{
                int count = map.get(a[i]);
                map.put(a[i], count+1);
            }
        }

        for (Map.Entry m : map.entrySet())
        {
            Integer temp = (Integer)m.getValue();
            if (temp > x)
                System.out.println(m.getKey());
        }

    }

}
