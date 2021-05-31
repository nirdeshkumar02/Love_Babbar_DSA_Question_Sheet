package Arrays;

import java.util.HashSet;
import java.util.Iterator;

public class union_intersection_of_sorted_arrays {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5};
        int m = a.length;
        int b[] = {1,2,3};
        int n = b.length;
        System.out.println(union(a,b,m,n));
        System.out.println(intersection(a,b,m,n));
    }

    private static int intersection(int[] a, int[] b, int m, int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i =0; i< m; i++){
            set.add(a[i]);
        }

        for(int i = 0; i<n; i++){
            if(set.contains(b[i])){
                System.out.print(b[i]+" ");
            }
        }
        System.out.println();
        return set.size();
    }

    private static int union(int[] a, int[] b, int m, int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Iterator itr = set.iterator();
        for(int i =0; i<m; i++){
            set.add(a[i]);
        }
        for(int i =0; i<n; i++){
            set.add(b[i]);
        }
        set.forEach(i -> System.out.print(i+" "));
        System.out.println();
        return(set.size());
    }
}
