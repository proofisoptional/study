package YandexContest;

import java.util.Scanner;

public class LongestIntSequence {
    public static int longSeq(int[] nums){
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            int temp = 0;
            if(nums[i] == 1){
                while(i<nums.length && nums[i] == 1){
                    temp++;
                    i++;
                }
                if(temp > res){
                    res = temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            int num = scanner.nextInt();
            nums[i] = num;
        }
        System.out.println(longSeq(nums));
    }
}
