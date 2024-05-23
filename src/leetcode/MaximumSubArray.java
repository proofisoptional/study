package leetcode;

import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSubArray {

    public static int helper(int[] nums, int pivot, int l, int r){
        int sum = 0;
        int left = Integer.MIN_VALUE;
        for(int i = pivot; i>=l; i--){
            sum = sum + nums[i];
            if(sum > left){
                left = sum;
            }
        }

        sum = 0;
        int right = Integer.MIN_VALUE;
        for(int i = pivot; i<r; i++){
            sum = sum + nums[i];
            if(sum > right){
                right = sum;
            }
        }

        return Math.max(left + right - nums[pivot], Math.max(left, right));
    }

    public static int helper2(int[] nums, int left, int right){
        if(left == right){
            return 0;
        }
        if(right - left == 1){
            return nums[left];
        }
        if(right - left == 2){
            return Math.max(Math.max(nums[left], nums[left + 1]), nums[left]+ nums[left+1]);
        }
        int pivot = (right + left)/2;

        return Math.max(Math.max(helper2(nums, left, pivot), helper2(nums, pivot+1, right)), helper(nums, pivot, left, right));

    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0) sum = 0;
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
