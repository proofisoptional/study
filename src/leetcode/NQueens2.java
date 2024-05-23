package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NQueens2 {
    static int res = 0;

    public static void helper(int x, int y, Map<Integer, Integer> curr, int count, int n){

        if(count == n){
            res = res + 1;
            return;
        }
        if(x>=n || y>=n){
            return;
        }

        if(curr.containsKey(x)){
            return;
        }
        if(curr.containsValue(y)){
            helper(x, y+1, curr,  count, n);
            return;
        }
        for(Integer mapx: curr.keySet()){
            Integer mapy = curr.get(mapx);
            if(Math.abs(mapx - x) ==  Math.abs(mapy - y)){
                helper(x, y+1, curr, count, n);
                return;
            }
        }

        curr.put(x, y);
        helper(x+1, 0, curr,  count + 1, n);
        curr.remove(x);
        helper(x, y+1, curr,  count, n);

    }

    public static int totalNQueens(int n) {
        Map<Integer, Integer> temp = new HashMap<>();
        helper(0, 0, temp, 0, n);
        int result = res;
        res = 0;
        return result;

    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(1));
    }
}
