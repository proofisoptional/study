package leetcode;

public class SortingColors {
    public static void sortColors(int[] nums) {
        int reds = 0, whites = 0, blue = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                reds++;
            }
            if(nums[i] == 1){
                whites++;
            }
            if(nums[i] == 2){
                blue++;
            }
        }

        for(int i = 0; i<nums.length; i++){
            if(i<reds){
                nums[i] = 0;
            }
            if(i >= reds && i<reds+whites){
                nums[i] = 1;
            }
            if(i >= reds+whites){
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] temp = new int[]{2,0,2,1,1,0};
        sortColors(temp);
        for(int i : temp){
            System.out.print(i + " ");
        }
    }
}
