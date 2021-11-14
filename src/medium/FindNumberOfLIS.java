package medium;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 */
public class FindNumberOfLIS {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        FindNumberOfLIS solution = new FindNumberOfLIS();
        int numberOfLIS = solution.findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int result = 0;
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }
        return result;
    }
}
