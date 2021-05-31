package Arrays;
/*
Given an array of integers where each element represents the max number of steps
that can be made forward from that element. Find the minimum number of jumps to reach the end of the array
(starting from the first element). If an element is 0, then you cannot move through that element.
 */
public class minimum_num_of_jumps_to_reach_at_end_of_array {
    public static void main(String[] args){
        int arr[] = {1 ,3 ,5 ,8 ,9 ,2 ,6 ,7 ,6 ,8 ,9};
        int n = arr.length;
        System.out.println(minJumps(arr, n));
    }

    private static int minJumps(int[] arr, int n) {
        // return 0 if length less than or equal to 1
        if(n <= 1) return 0;
        // Return -1 if not possible to jump
        if(arr[0] == 0) return -1;

        // Initialization
        int maxReach = arr[0];
        int steps = arr[0];
        int jump = 1;

        // traversing through the array
        for(int i =1; i< n; i++) {
            // check if we reached end of the array
            if (i == n - 1) return jump;
            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            // if no further steps left
            if (steps == 0) {
                jump++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }
}
