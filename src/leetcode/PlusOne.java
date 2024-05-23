package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if(digits[digits.length - 1] != 9){
            digits[digits.length - 1]++;
            return digits;
        } else {
            if(digits.length == 1){
                return new int[]{1, 0};
            }
            int[] temp = Arrays.copyOfRange(digits, 0, digits.length - 1);
            temp = plusOne(temp);
            return Arrays.copyOf(temp, temp.length+1);
        }
    }

    public static void main(String[] args) {
        int[] data = {9,9,9,9};
        int[] res = plusOne(data);
        for(int s: res){
            System.out.println(s);
        }
    }
}
