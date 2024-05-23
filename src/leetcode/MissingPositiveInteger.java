package leetcode;

import java.util.Hashtable;

public class MissingPositiveInteger {
    public static int firstMissingPositive(int[] nums) {
        int neg = 0;
        int index = 1;
        Hashtable<Integer, Integer> tbl = new Hashtable<>();
        for(int s: nums){
            if(s>0){
                if(s==index){
                    index++;
                    while(tbl.containsKey(index)){
                        index++;
                    }
                }
                tbl.put(s, index);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
