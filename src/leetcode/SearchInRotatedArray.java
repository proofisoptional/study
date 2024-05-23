package leetcode;

import java.util.Arrays;

public class SearchInRotatedArray {
    public static boolean search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return true;
            } else {
                return false;
            }
        }
        int k = nums.length/2;
        if(nums[k] == target || nums[0] == target || nums[nums.length-1] == target){
            return true;
        }
        if(nums[k]==nums[nums.length-1]){
            return search(Arrays.copyOfRange(nums, 0, k), target) || search(Arrays.copyOfRange(nums, k, nums.length), target);
        }

        if(target>nums[k]){
            if(nums[k]<nums[nums.length-1]){
                if(target<nums[nums.length-1]){
                    return search(Arrays.copyOfRange(nums, k, nums.length), target);
                } else {
                    return search(Arrays.copyOfRange(nums, 0, k), target);
                }
            } else if (nums[k]>nums[nums.length-1]){
                if(target<nums[nums.length-1]){
                    return search(Arrays.copyOfRange(nums, 0, k), target);
                } else {
                    return search(Arrays.copyOfRange(nums, k, nums.length), target);
                }
            } else if(nums[k]==nums[nums.length-1]){
                if(target<nums[nums.length-1]){
                    return search(Arrays.copyOfRange(nums, 0, k), target);
                } else {
                    return search(Arrays.copyOfRange(nums, k, nums.length), target);
                }
            }
        } else if(target<nums[k]){
            if(nums[0]<nums[k]){
                if(nums[0]<target){
                    return search(Arrays.copyOfRange(nums, 0, k), target);
                } else {
                    return search(Arrays.copyOfRange(nums, k, nums.length), target);
                }
            } else if(nums[0]>nums[k]){
                if(nums[0]<target){
                    return search(Arrays.copyOfRange(nums, k, nums.length), target);
                } else {
                    return search(Arrays.copyOfRange(nums, 0, k), target);
                }
            } else if(nums[0]==nums[k]){
                if(nums[0]<target){
                    return search(Arrays.copyOfRange(nums, 0, k), target);
                } else {
                    return search(Arrays.copyOfRange(nums, k, nums.length), target);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums2 = new int[]{2,2,2,0,1};
        System.out.println(search(nums, 0));
        System.out.println(search(nums2, 0));
    }

}
