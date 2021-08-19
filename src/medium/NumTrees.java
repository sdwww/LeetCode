package medium;

/**
 * 96. 不同的二叉搜索树
 *
 * @author www
 */
public class NumTrees {
    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        int i = numTrees.numTrees(4);
        System.out.println(i);
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2}+...+dp[n-2]*dp[1]+dp[n-1]*dp[0]
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}