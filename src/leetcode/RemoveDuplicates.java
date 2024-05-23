package leetcode;
/*https://leetcode.com/problems/remove-duplicates-from-sorted-array/*/

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int picker = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[picker]){
                nums[++picker] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : picker + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 2, 2 ,2, 3, 4, 4};
        System.out.println(removeDuplicates(nums));

        for(int i : nums){
            System.out.print(i + ", ");
        }
    }
}
