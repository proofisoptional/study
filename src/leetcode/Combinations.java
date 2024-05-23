package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k==1){
            for(int i = 1; i<n+1; i++){
                List<Integer> list = Arrays.asList(i);
                result.add(list);
            }
            return result;
        }
        int counter = 1;
        while(counter<n+1){
            int dot = counter;
            List<Integer> temp = new ArrayList<>();
            while(dot<n+1){
                temp.add(dot);
                dot++;
                if(temp.size()==k){
                    result.add(new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                }
                while(dot==n+1){
                    if(temp.size()==1){
                        break;
                    }
                    int point = temp.get(temp.size()-1);
                    dot = point+1;
                    temp.remove(temp.size()-1);
                }
            }
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(5, 4));
    }
}
