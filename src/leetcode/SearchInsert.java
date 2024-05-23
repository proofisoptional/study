package leetcode;
//https://leetcode.com/problems/search-insert-position/description/

import java.util.Arrays;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(target<nums[0]){
            return 0;
        }

        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }
            if(nums[0]>target){
                return 0;
            }
            if(nums[0]<target){
                return 1;
            }
        }



        int pivot = length/2;
        if(nums[pivot] < target){
            int[] newarr = Arrays.copyOfRange(nums, pivot, length);
            int middleres = searchInsert(newarr, target);
            if(middleres == -1){
                return pivot+1;
            }
            return pivot + middleres;
        }
        if(nums[pivot] > target){
            int[] newarr = Arrays.copyOfRange(nums, 0, pivot);
            int middleres = searchInsert(newarr, target);
            if(middleres == -1){
                return 1;
            }
            return middleres;
        }

        if(nums[pivot] == target){
            return pivot;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7,9,11,15,16};
        System.out.println(searchInsert(arr, 13));
    }

}
