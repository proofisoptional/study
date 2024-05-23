package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>(Arrays.asList(nums[i])));
            for(int j = 0; j<res.size(); j++){
                List<Integer> tempList = new ArrayList<>(res.get(j));
                tempList.add(nums[i]);
                temp.add(tempList);
            }
            res.addAll(temp);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
