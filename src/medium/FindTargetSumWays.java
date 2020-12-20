package medium;

/**
 * 494. 目标和
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        FindTargetSumWays solution = new FindTargetSumWays();
        int targetSumWays = solution.findTargetSumWays(new int[]{7, 9, 3, 8, 0, 2, 4, 8, 3, 9}, 0);
//        int targetSumWays = solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum || (sum - S) % 2 == 1) {
            return 0;
        }
        int temp = (sum - S) / 2;
        int[][] dp = new int[nums.length + 1][temp + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][temp];
    }
}
