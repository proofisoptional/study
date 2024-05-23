package leetcode;

public class RotateMatrix {

    public static String matrixToString(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< matrix.length; i++){
            sb.append("[");
            for(int j = 0; j<matrix[0].length; j++){
                sb.append(matrix[i][j]);
                sb.append(' ');
            }
            sb.append("]");
        }

        return sb.toString();
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(matrixToString(matrix));
    }
}
