package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
https://leetcode.com/problems/3sum/
*/

public class ThreeSum {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        quickSort(nums, 0, nums.length-1);
        int start = 0;
        if(nums[start]>0){
            return res;
        }
        while(start<nums.length && nums[start]<=0){
            if(start>0 && nums[start] == nums[start-1]){
                start++;
                continue;
            }
            int j = start+1;
            int k = nums.length-1;
            while(j<k){
                if(j>start+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k<nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                if(nums[start] + nums[j] + nums[k] > 0){
                    k--;
                    continue;
                }
                if(nums[start] + nums[j] + nums[k] < 0){
                    j++;
                    continue;
                }
                if(nums[start] + nums[j] + nums[k] == 0){
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[start], nums[j], nums[k]));
                    res.add(temp);
                    j++;
                }
            }
            start++;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 0};
        List<List<Integer>> threeset = threeSum(arr);
        for(List<Integer> temp : threeset){
            System.out.println(temp.toString());
        }
    }
}
