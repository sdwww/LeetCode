package medium;

/**
 * 剑指 Offer 63. 股票的最大利润
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // 时间复杂度O(n),空间复杂度O(1)
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if ((prices[i] - min) > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    // 时间复杂度O(n),空间复杂度O(n)
    public int maxProfitPoor(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] min = new int[prices.length];
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(prices[i], min[i - 1]);
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - min[i] > maxProfit) {
                maxProfit = prices[i] - min[i];
            }
        }
        return maxProfit;
    }
}
