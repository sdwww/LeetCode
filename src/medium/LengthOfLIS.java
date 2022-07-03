package medium;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 0};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int i = lengthOfLIS.lengthOfLIS(nums);
        System.out.println(i);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 以nums[i]结尾的最长递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
