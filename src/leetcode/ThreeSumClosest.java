package leetcode;

public class ThreeSumClosest {
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
    public static int threeSumClosest(int[] nums, int target) {
        quickSort(nums, 0, nums.length-1);
        int res = nums[0] + nums[1] + nums[nums.length-1];
        int diff = Math.abs(res - target);
        int start = 0;
        while(start<nums.length-1){
            if(start>0 && nums[start] == nums[start-1]){
                start++;
                continue;
            }
            int j = start + 1;
            int k = nums.length -1;
            while(j<k){
                if(j>start+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k<nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                int temp = nums[start] + nums[j] + nums[k];
                if(temp<target){
                    if(Math.abs(temp-target)<diff){
                        diff = Math.abs(temp-target);
                        res = temp;
                    }
                    j++;
                }
                if(temp>target){
                    if(Math.abs(temp-target)<diff){
                        diff = Math.abs(temp-target);
                        res = temp;
                    }
                    k--;
                }
                if(temp == target){
                    return target;
                }


            }
            start++;
        }
        return res;
    }
/*
[-100,-98,-2,-1]
-101

 */
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-100,-98,-2,-1}, -101));
    }
}
