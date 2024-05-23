package leetcode;

/*https://leetcode.com/problems/remove-element/*/

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int picker = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[picker] = nums[i];
                picker++;
            }
        }

        return nums.length == 0 ? 0 : picker;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
        for(int i: arr){
            System.out.println(i + ", ");
        }
    }
}
