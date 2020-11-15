package medium;

/**
 * 1155. 掷骰子的N种方法
 */
public class NumRollsToTarget {

    static long count = 0;

    public static void main(String[] args) {
        NumRollsToTarget solution = new NumRollsToTarget();
        System.out.println(solution.numRollsToTarget(30, 30, 500));
        System.out.println(solution.numRollsToTarget(1, 2, 3));
    }

    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d][target];
        for (int i = 0; i < f && i < target; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < d; i++) {
            for (int j = 1; j < target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j - k < 0) {
                        continue;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= (1000000007);
                }
            }
        }
        return dp[d - 1][target - 1];
    }
}
