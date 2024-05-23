package leetcode;
//https://leetcode.com/problems/container-with-most-water/submissions/

import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
//        if(height.length == 1){
//            return 0;
//        }
//        int ans = 0;
//        if(height[0] < height[height.length-1]){
//            ans = height[0]*(height.length-1);
//            return Math.max(ans, maxArea(Arrays.copyOfRange(height, 1, height.length)));
//        } else {
//            ans = height[height.length-1]* (height.length-1);
//            return Math.max(ans, maxArea(Arrays.copyOfRange(height, 0, height.length-1)));
//        }

        int i = 0;
        int j = height.length-1;
        int ans = 0;
        while(i != j){
            int temp = 0;
            if(height[i] < height[j]){
                temp = height[i]*(j-i);
                i++;
            } else {
                temp = height[j] * (j-i);
                j--;
            }
            if(temp>ans){
                ans = temp;
            }

        }

        return ans;

    }
}
