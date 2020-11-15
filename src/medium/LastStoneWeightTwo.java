package medium;

import java.util.stream.IntStream;

/**
 * 1049. 最后一块石头的重量 II
 */
public class LastStoneWeightTwo {

    public static void main(String[] args) {
        LastStoneWeightTwo solution = new LastStoneWeightTwo();
//        int[] arr = {2, 7, 4, 1, 8, 1};
        int[] arr = {14, 1, 7, 17, 8, 10};
//        int[] arr = {53, 54, 3, 61, 67};
        System.out.println(solution.lastStoneWeightII(arr));
    }

    public int lastStoneWeightII(int[] stones) {
        int totalSum = IntStream.of(stones).sum();
        int halfSum = totalSum / 2;
        int[][] dp = new int[stones.length][halfSum + 1];
        for (int j = 0; j <= halfSum; j++) {
            dp[0][j] = j >= stones[0] ? stones[0] : 0;
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j <= halfSum; j++) {
                if (j - stones[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - stones[i]] + stones[i]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return totalSum - 2 * dp[stones.length - 1][halfSum];
    }
}
