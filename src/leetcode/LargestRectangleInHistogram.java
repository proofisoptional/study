package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int[] lessFromRight = new int[heights.length];
        int[] lessFromLeft = new int[heights.length];

        lessFromRight[heights.length-1] = heights.length;
        lessFromLeft[0] = -1;
        for(int i = 1; i<heights.length; i++){
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i]){
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for(int i = heights.length-2; i>=0; i--){
            int p = i+1;
            while(p<heights.length && heights[p]>=heights[i]){
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int maxArea = 0;
        for(int i = 0; i<heights.length; i++){
            int local = heights[i] * (lessFromRight[i] - lessFromLeft[i]-1);
            if(local>maxArea){
                maxArea = local;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        for(char c = 'A'; c<='H'; c++){
            System.out.println("<td><div class=\"text-center\" style=\"word-break: break-word\" th:text=\"${row?._7_"+c+"}\"></div></td>");
        }

    }

    }
