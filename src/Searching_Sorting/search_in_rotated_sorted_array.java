package Searching_Sorting;
import java.util.*;

public class search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(LinearSearchInRotatedArray(nums, target));
        System.out.println(BinarySearchInRotatedArray(nums, target));
    }

    private static int BinarySearchInRotatedArray(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] < nums[mid]) {
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid - 1;
                }
            }

        }
        return  -1;
    }

    private static int LinearSearchInRotatedArray(int[] nums, int target) {
        for(int n : nums){
            if(nums[n] == target)
                return n;
        }
        return -1;
    }
}
