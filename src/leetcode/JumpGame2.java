package leetcode;

public class JumpGame2 {
    static boolean reached = false;
    public static void helper(int[] nums, int index){
        if(index >= nums.length){
            return;
        }
        if(index == nums.length - 1){
            reached = true;
        }
        for(int i = 0; i< nums[index]; i++){
            helper(nums, index +i);
        }


    }
    public static boolean canJump(int[] nums) {
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(canJump(nums));
    }
}
