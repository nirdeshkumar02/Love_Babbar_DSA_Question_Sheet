package Arrays;

public class next_permutation {
    public static void main(String[] args){
        int nums[] = {1,2,3};
        nextPermutation(nums);
        printArray(nums);

    }

    private static void printArray(int[] nums) {
        for(int num: nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int ip = n - 2;
        while (ip >= 0 && nums[ip] >= nums[ip + 1]) {
            ip--;
        }

        if (ip >= 0) {
            for (int i = n - 1; i > ip; i--) {
                if (nums[i] > nums[ip]) {
                    swap(nums, i, ip);
                    break;
                }
            }
        }

        reverse(nums, ip + 1, n);
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int from, int to) {
        for (int i = from, j = to - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}
