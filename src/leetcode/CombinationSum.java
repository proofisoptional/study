package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;





public class CombinationSum {

    public static void returnHelper(List<List<Integer>> list){
        StringBuilder sb = new StringBuilder();
        for(List<Integer> sublist: list){
            sb.append("[ ");
            for(Integer val: sublist){
                sb.append(val);
                sb.append(" ");
            }
            sb.append("]");
        }
        System.out.println(sb.toString());
    }


    public static void helper(int[] candidates, List<List<Integer>> result, int target, int index, List<Integer> temp){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(candidates[index] <= target){
            temp.add(candidates[index]);
            helper(candidates, result, target - candidates[index], index, temp);
            temp.remove(temp.size() - 1);
        }
        helper(candidates, result, target, index + 1, temp);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, res, target, 0, new ArrayList<Integer>());
        return res;


    }

    public static void main(String[] args) {
        int[] values = new int[]{2, 3, 6, 7};
        returnHelper(combinationSum(values, 7));
    }
}
