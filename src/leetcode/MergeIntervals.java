package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int count = 0;
        for(int i = 0; i<intervals.length-1; i++){
            int end = intervals[i][1];
            while(i<intervals.length-1 && end>=intervals[i+1][0]){
                i++;
                count++;
                if(intervals[i][1] > end){
                    end = intervals[i][1];
                }

            }
        }
        int index = 0;
        int[][] res = new int[intervals.length - count][2];
        for(int i = 0; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i<intervals.length-1 && end>=intervals[i+1][0]){
                i++;
                if(intervals[i][1] > end){
                    end = intervals[i][1];
                }

            }
            res[index] = new int[]{start, end};
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}});
        int[][] res1 = merge(new int[][]{{1,4}, {4,5}});
        int[][] res2 = merge(new int[][]{{2,3}, {4,5}, {6,7}, {8,9}, {1,10}});
        System.out.println(res);
    }
}
