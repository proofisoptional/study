package leetcode;

import java.util.Arrays;

public class InsertInterval {

    public static boolean cross(int[] interval1, int[] interval2){
        if(interval1[0]>interval2[0]){
            if(interval1[0]-interval2[1] > 0){
                return false;
            }
        }
        if(interval2[0]>interval1[0]){
            if(interval2[0] - interval1[1] > 0){
                return false;
            }
        }
        return true;
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        boolean intersected = false;
        if(intervals.length==0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int count = 0;
        for(int i = 0; i<intervals.length; i++){
            if(cross(intervals[i], newInterval)){
                intersected = true;
                while(i<intervals.length && cross(intervals[i], newInterval)){
                    count++;
                    i++;
                }
            }
        }
        int index = 0;
        int[][] res = new int[intervals.length-count+1][2];
        if(!intersected){
            for(int i = 0; i<intervals.length; i++){
                int start = intervals[i][0];
                int end = intervals[i][1];
                if(i==0 && newInterval[0]<intervals[i][0]){
                    res[index] = new int[]{newInterval[0], newInterval[1]};
                    index++;
                } else if(newInterval[0]<intervals[i][0] && newInterval[0]>intervals[i-1][1]){
                    res[index] = new int[]{newInterval[0], newInterval[1]};
                    index++;
                }
                res[index] = new int[]{start, end};
                index++;
            }

            if(newInterval[0]>intervals[intervals.length-1][1]){
                res[index] = new int[]{newInterval[0], newInterval[1]};
            }
            return res;

        }

        for(int i = 0; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(cross(intervals[i], newInterval)){
                start = intervals[i][0]<newInterval[0]?intervals[i][0]:newInterval[0];
                while(i<intervals.length && cross(intervals[i], newInterval)){
                    end = intervals[i][1]>newInterval[1]?intervals[i][1]:newInterval[1];
                    i++;
                }
                i--;
            }
            res[index] = new int[]{start, end};
            index++;

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[][] intervals2 = new int[][]{{1,5}};
        int[][] insert = insert(intervals2, new int[]{6, 8});

        System.out.println(cross(new int[]{1, 3}, new int[]{3, 5}));
        System.out.println(cross(new int[]{3, 5}, new int[]{1, 3}));
        System.out.println(cross(new int[]{2, 4}, new int[]{7, 8}));
        System.out.println(cross(new int[]{1, 10}, new int[]{5, 7}));
        System.out.println(cross(new int[]{4, 8}, new int[]{8, 10}));
    }
}
