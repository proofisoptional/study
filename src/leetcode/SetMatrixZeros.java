package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMatrixZeros {
    public static void setZeroes(int[][] matrix) {
        Set<Integer> is = new HashSet<>();
        Set<Integer> js = new HashSet<>();
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    is.add(i);
                    js.add(j);
                }
            }
        }

        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(is.contains(i) || js.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

    }
}
