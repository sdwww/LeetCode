/**
 * @(#)CoinChange.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * @author www
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] nums = {1, 2, 5};
        int i = coinChange.coinChange(nums, 11);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 每个元素设置为整数最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    // 核心逻辑
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}