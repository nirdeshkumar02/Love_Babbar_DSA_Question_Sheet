package Arrays;

import java.util.HashSet;

public class find_duplicate_in_array_of_n_plus_one_integer {
    public static void main(String[] args){
        int nums[] = { 3,1,3,4,2};
        int n = nums.length;
        System.out.println(duplicate(nums));
    }

    private static int duplicate(int[] nums) {

//        1st method
        int arr[] = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
            arr[nums[i]]++; //Visit the elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1)
                return i; // Return the first repeat
        }
        return 0;

//        2nd using hashset
        /*
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;

         */
    }
}
