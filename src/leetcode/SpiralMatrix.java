package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean rotate = true;
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        short direction = 1;
        int i = 0;
        int j = 0;
        while(rotate){
            while(direction == 1){
                if(j == matrix[0].length || visited[i][j]){
                    rotate = false;
                    break;
                }
                res.add(matrix[i][j]);
                visited[i][j] = true;
                j++;
                if(j == matrix[0].length || visited[i][j]){
                    j--;
                    i = i + 1;
                    direction = 2;
                }
            }
            while(direction == 2){
                if(i == matrix.length || visited[i][j]){
                    rotate = false;
                    break;
                }
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i++;
                if(i == matrix.length || visited[i][j]){
                    i--;
                    j = j - 1;
                    direction = 3;
                }
            }
            while(direction == 3){
                if(j<0 || visited[i][j]){
                    rotate = false;
                    break;
                }
                res.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
                if(j<0 || visited[i][j]){
                    j++;
                    i = i - 1;
                    direction = 4;
                }
            }
            while(direction == 4){
                if(i<0 || visited[i][j]){
                    rotate = false;
                    break;
                }
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
                if(i<0 || visited[i][j]){
                    i++;
                    j = j + 1;
                    direction = 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = new int[][]{{1}};
        System.out.println(spiralOrder(matrix));
    }
}
