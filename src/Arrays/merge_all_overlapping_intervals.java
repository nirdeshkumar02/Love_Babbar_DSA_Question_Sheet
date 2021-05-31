package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_all_overlapping_intervals {
    public static void main(String[] args){
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }

    private static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int size = 0;
        int point1 = intervals[0][0];
        int point2 = intervals[0][1];
        for(int i = 1; i<intervals.length; i++) {
            if(point2>=intervals[i][0]) {
                if(point2<=intervals[i][1]) {
                    point2 = intervals[i][1];
                }
            } else {
                intervals[size][0] = point1;
                intervals[size][1] = point2;
                size++;
                point1 = intervals[i][0];
                point2 = intervals[i][1];
            }
        }
        intervals[size][0] = point1;
        intervals[size][1] = point2;
        return Arrays.copyOf(intervals, size+1);



        /*

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> output = new ArrayList<>();
        int startTime = intervals[0][0], endTime = intervals[0][1];
        for(int[] interval: intervals) {
            if(interval[0] <= endTime) {
                endTime = Math.max(endTime, interval[1]);
            } else {
                output.add(new int[]{startTime, endTime});
                startTime = interval[0];
                endTime = interval[1];
            }
        }
        output.add(new int[]{startTime, endTime});
        return output.toArray(new int[output.size()][2]);

        */





        /*
        // dynamic arraylist
        ArrayList<int[]> ans = new ArrayList<>();

        // check for base condition
        if(intervals.length == 0){
            return ans.toArray(new int [0][]);
        }

//        using comparable class, sort the array
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //Then create two pointers 1. start 2.end in pair
        int start = intervals[0][0];
        int end = intervals[0][1];

        //Using for loop to occurrence in intervals one by one
        for(int i = 1; i< intervals.length; i++){

            //Basically no overlap condition
            if(intervals[i][0] > end){
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            //overlap condition
            else if(intervals[i][1] >= end){
                end = intervals[i][1];
            }
        }
        //final pair
        ans.add(new int[]{start , end});
        return ans.toArray(new int[0][]);

         */
    }
}
