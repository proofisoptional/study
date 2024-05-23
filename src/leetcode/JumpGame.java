package leetcode;

import horstmann_lessons.lambda_expressions.Person;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        if(nums[0] == 0){
            return false;
        }
        int index = 0;
        int maxreach = 0;
        int nextindex = 0;
        while (true){
            for(int i = 1; i<=nums[index]; i++){
                if(index + i >= nums.length - 1){
                    return true;
                }
                if(nums[index + i] == 0){
                    continue;
                }
                int temp = i + nums[index + i];
                if(temp > maxreach){
                    maxreach = temp;
                    nextindex = index + i;

                }
            }
            if(maxreach == 0){
                return false;
            }

            index = nextindex;
            if(index >= nums.length){
                return true;
            }

            if(nums[index] == 0){
                return false;
            }
            maxreach = 0;
        }

    }

    //leetcode greedy solution
    public static boolean canJump2(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(nums));
    }
}
