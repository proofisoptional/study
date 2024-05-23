package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
public class SearchRangeinSortedArray {


    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return new int[]{-1, -1};
        }
        if(length == 1 && nums[0] != target){
            return new int[]{-1, -1};
        }
        if(length == 2){
            if(nums[0] == target || nums[1] == target){
                if(nums[0] == target && nums[1] == target){
                    return new int[]{0, 1};
                }
                if(nums[0] == target){
                    return new int[]{0, 0};
                }
                if(nums[1] == target){
                    return new int[]{1, 1};
                }
            } else {
                return new int[]{-1, -1};
            }
        }
        int pivot = length/2;
        if(nums[pivot]<target){
            int[] newarr = Arrays.copyOfRange(nums, pivot, length);
            int[] middleres = searchRange(newarr, target);
            if(middleres[0] == -1){
                return new int[]{-1, -1};
            }
            return new int[]{pivot + middleres[0], pivot + middleres[1]};
        }
        if(nums[pivot]>target){
            int[] newarr = Arrays.copyOfRange(nums, 0, pivot);
            int[] middleres = searchRange(newarr, target);
            if(middleres[0] == -1){
                return new int[]{-1, -1};
            }
            return new int[]{middleres[0], middleres[1]};
        }
        if(nums[pivot] == target){
            int i = pivot;
            while(i>=0 && nums[i] == target){
                i --;
            }
            int j = pivot;
            while(j<length && nums[j] == target){
                j++;
            }
            return new int[]{i+1, j-1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,7,7,8,8,10};
        int[] res = searchRange(arr, 8);
        System.out.println(res[0] +", "+ res[1]);
    }
}
