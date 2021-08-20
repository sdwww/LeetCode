package medium;

/**
 * 264. 丑数 II
 * 剑指 Offer 49. 丑数
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        NthUglyNumber solution = new NthUglyNumber();
        System.out.println(solution.nthUglyNumber(1690));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[index2] * 2, dp[index3] * 3), dp[index5] * 5);
            if (dp[i] == dp[index2] * 2) {
                index2++;
            }
            if (dp[i] == dp[index3] * 3) {
                index3++;
            }
            if (dp[i] == dp[index5] * 5) {
                index5++;
            }
        }
        return dp[n - 1];
    }
}
