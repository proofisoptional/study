package leetcode;

public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean onepath = false;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }
        if(obstacleGrid[0].length==1){
            onepath = true;
        }
        if(onepath && obstacleGrid.length == 1){
            if(obstacleGrid[0][0]==0){
                return 1;
            } else {
                return 0;
            }
        }
        int[][] table = new int[obstacleGrid.length][obstacleGrid[0].length];
        table[0][0] = 1;
        for(int i = 0; i<obstacleGrid.length; i++){
            for(int j = 0; j<obstacleGrid[0].length; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(obstacleGrid[i][j] == 1){
                    if(onepath){
                        return 0;
                    }
                    table[i][j] = 0;
                    continue;
                }
                if(i==0){
                    table[i][j] = table[i][j-1];
                }
                else if(j==0){
                    table[i][j] = table[i-1][j];
                } else {
                    table[i][j] = table[i-1][j] + table[i][j-1];
                }

            }
        }

        return table[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
