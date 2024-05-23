package leetcode;

public class SearchIn2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i<matrix.length; i++){
            if(matrix[i][matrix[0].length] < target){
                continue;
            }
            if(matrix[i][0] > target){
                return false;
            } else {
                for(int num : matrix[i]){
                    if(num == target){
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
