package medium;

/**
 * 518. 零钱兑换 II
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] board = {1, 2, 5};
        System.out.println(solution.change(5, board));
    }


    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
