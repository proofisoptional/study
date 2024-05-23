package leetcode;

import java.util.Arrays;

public class UniqueNumberInPairs {
    public static int findUnique(int[] arr){
        int result = arr[0];
        for(int i = 1; i<arr.length; i++){
            result = result ^ arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 8, 6, 4, 1, 1, 7, 8, 6, 7, 2};
        int x = Arrays.stream(arr).reduce(0, (a, b) -> a ^ b);
        System.out.println(x);

    }
}
