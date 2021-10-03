/**
 * @(#)CanPartition.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 416. 分割等和子集
 *
 * @author wangweiwei
 */
public class CanPartition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        CanPartition solution = new CanPartition();
        boolean b = solution.canPartition(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果和为奇数，返回false
        if (sum % 2 == 1) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 1;
        for (int num : nums) {
            // 每个元素必须不重复的放入,倒序是为了避免当前数字对后续的影响
            for (int i = sum / 2; i >= num; i--) {
                // dp[i]代表有多少种情况加起来得到i
                dp[i] += dp[i - num];
            }
        }
        return dp[sum / 2] != 0;
    }
}