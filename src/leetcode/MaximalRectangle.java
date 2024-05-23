package leetcode;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                int width = matrix[0].length;
                int length = matrix.length;
                if(matrix[i][j] == '1'){
                    int c = j;
                    while(c<matrix[0].length && matrix[i][c]!='0'){
                        c++;
                    }
                    for(int f = j; f<c; f++){
                        int k = i;
                        while(k<matrix.length && matrix[k][f] != '0'){
                            k++;
                        }
                        if(length>k-i){
                            length = k-i;
                        }
                        int newArea = (f-j+1)*(length);
                        if(newArea > maxArea){
                            maxArea = newArea;
                        }
                    }
                }

            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        char[][] matrix1 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        char[][] matrix2 = {{'1'}};
        System.out.println(maximalRectangle(matrix1));
    }
}
