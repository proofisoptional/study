package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NQueens {

    public static void helper(int x, int y, Map<Integer, Integer> curr, List<List<String>> res, int count, int n){

        if(count == n){
            List<String> temp = new ArrayList<>();
            List<Integer> xcoords = new ArrayList<>(curr.keySet());
            StringBuilder s = new StringBuilder();
            for(int i = 0; i<n; i++){
                s.append('.');
            }
            for(Integer xcoord: xcoords){
                StringBuilder sb = new StringBuilder(s);
                Integer ycoord = curr.get(xcoord);
                sb.setCharAt(ycoord, 'Q');
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        if(x>=n || y>=n){
            return;
        }

        if(curr.containsKey(x)){
            return;
        }
        if(curr.containsValue(y)){
            helper(x, y+1, curr, res, count, n);
            return;
        }
        for(Integer mapx: curr.keySet()){
            Integer mapy = curr.get(mapx);
            if(Math.abs(mapx - x) ==  Math.abs(mapy - y)){
                helper(x, y+1, curr, res, count, n);
                return;
            }
        }

        curr.put(x, y);
        helper(x+1, 0, curr, res, count + 1, n);
        curr.remove(x);
        helper(x, y+1, curr, res, count, n);

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, Integer> temp = new HashMap<>();
        helper(0, 0, temp, result, 0, n);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> l = solveNQueens(11);
        System.out.println(l);
    }
}
