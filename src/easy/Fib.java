package easy;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * @author www
 */
public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();
        int fib1 = fib.fib(5);
        System.out.println(fib1);
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}