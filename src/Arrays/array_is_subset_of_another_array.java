package Arrays;

import java.util.HashSet;

public class array_is_subset_of_another_array {
    public static void main(String[] args){
        int a1[] = {10, 5, 2, 23, 19};
        int a2[] = {19, 5, 3};

        System.out.println(A1IsSubset(a1, a2));
    }

    private static boolean A1IsSubset(int[] a1, int[] a2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i< a1.length; i++){
            set.add(a1[i]);
        }

        Boolean flag = true;

        for(int i =0; i< a2.length; i++){
            if(!set.contains(a2[i])){
                flag = false;
            }
            else{
                flag = true;
            }
        }
        return flag;
    }
}
