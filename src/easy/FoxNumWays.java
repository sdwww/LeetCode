package easy;

/**
 * @date 2020/10/2 18:43
 * Description:剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class FoxNumWays {
    public static void main(String[] args) {
        FoxNumWays solution = new FoxNumWays();
        System.out.println(solution.numWays(0));
        System.out.println(solution.numWays(7));
    }

    public int numWays(int n) {
        int[] ways = new int[101];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % 1000000007;
        }
        return ways[n];
    }
}
