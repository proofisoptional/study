package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates2 {
    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int shiftCounter = 0;
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                if(shiftCounter!=0){
                    nums[i-shiftCounter] = nums[i];
                }
            } else {
                int count = map.get(nums[i]);
                if(count<2){
                    map.put(nums[i], 2);
                    if(shiftCounter!=0){
                        nums[i-shiftCounter] = nums[i];
                    }
                } else {
                    shiftCounter++;
                }
            }
        }


        return nums.length - shiftCounter;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
