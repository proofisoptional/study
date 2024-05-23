package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {

    public static int sumOfArray(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

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

    public static void helper(int[] cand, int target, List<Integer> temp, List<List<Integer>> result){if(cand.length==0){
                if(target == 0){
                    for(List<Integer> sample : result){
                        if(sample.equals(temp)){
                            return;
                        }
                    }
                    result.add(new ArrayList<>(temp));
                }
                return;
            }

        if(sumOfArray(cand) < target){
            return;
        }
            int[] newarr = Arrays.copyOfRange(cand, 1, cand.length);


            if(cand[0]<=target){
                temp.add(cand[0]);
                helper(newarr, target - cand[0], temp, result);
                temp.remove(temp.size() - 1);
            }
            if(sumOfArray(newarr) < target){
                return;
            }
            helper(newarr, target, temp, result);




    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), res);

        return res;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        returnHelper(combinationSum2(values, 30));
    }
}
