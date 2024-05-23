package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://leetcode.com/problems/4sum/
 */

public class FourSum {
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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        quickSort(nums, 0, nums.length-1);
        int start = 0;
        while(start<nums.length-1){
            if(start>0 && nums[start] == nums[start - 1]){
                start++;
                continue;
            }
            int j = start + 1;
            while(j<nums.length-1){
                if(j>start + 1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                int i = j + 1;
                int k = nums.length - 1;
                while(i<k){
                    if(i>j+1 && nums[i] == nums[i-1]){
                        i++;
                        continue;
                    }
                    if(k<nums.length-1 && nums[k] == nums[k+1]){
                        k--;
                        continue;
                    }

                    long temp = (long)nums[start] + (long)nums[i] + (long)nums[j] + (long)nums[k];
                    if(temp>(long)target){
                        k--;
                        continue;
                    }
                    if(temp<(long)target){
                        i++;
                        continue;
                    }
                    if(temp==(long)target){
                        List<Integer> subarr = new ArrayList<>(Arrays.asList(nums[start], nums[j], nums[i], nums[k]));
                        res.add(subarr);
                        i++;
                    }
                }
                j++;
            }
            start++;

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},
        -294967296
));
    }
}
