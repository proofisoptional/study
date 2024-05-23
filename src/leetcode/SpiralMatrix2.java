package leetcode;

public class SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0;
        int j = 0;
        int direction = 1;
        int count = 1;

        while(count <= Math.pow(n, 2)){
            if(direction == 1){
                while((j<n && res[i][j]==0)){
                    res[i][j] = count;
                    count++;
                    j++;
                }
                j=j-1;
                i=i+1;
                direction = 2;
                continue;
            }

            if(direction == 2){
                while((i<n && res[i][j]==0)){
                    res[i][j] = count;
                    count++;
                    i++;
                }
                i=i-1;
                j=j-1;
                direction = 3;
                continue;
            }

            if(direction == 3){
                while((j>=0 && res[i][j]==0)){
                    res[i][j] = count;
                    count++;
                    j--;
                }
                j=j+1;
                i=i-1;
                direction = 4;
                continue;
            }
            if(direction == 4){
                while((i>=0 && res[i][j]==0)){
                    res[i][j] = count;
                    count++;
                    i--;
                }
                i=i+1;
                j=j+1;
                direction = 1;
                continue;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println("done");
    }
}
