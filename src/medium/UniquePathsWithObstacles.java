package medium;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int[][] nums = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        int[][] nums = {{0, 1}, {0, 0}};
        int i = uniquePathsWithObstacles.uniquePathsWithObstacles(nums);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // 如果是障碍物，赋值为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 否则取左边和上面的和
                if (j >= 1) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (i >= 1) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
