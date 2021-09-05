/**
 * @(#)MaxProfitTwo.java, 9月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author wangweiwei
 */
public class MaxProfitTwo {

    public static void main(String[] args) {
        MaxProfitTwo maxProfitTwo = new MaxProfitTwo();
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfitTwo.maxProfit(nums);
        System.out.println(i);
    }

    // 贪心算法
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}