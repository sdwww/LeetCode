package medium;

/**
 * 931. 下降路径最小和
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        MinFallingPathSum solution = new MinFallingPathSum();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.minFallingPathSum(grid));
    }

    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int min;
                if (j == 0) {
                    min = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == A.length - 1) {
                    min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
                }
                dp[i][j] += A[i][j] + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[A.length - 1]) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
