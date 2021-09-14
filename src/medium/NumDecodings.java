package medium;

/**
 * 91. 解码方法
 *
 * @author wangweiwei
 */
public class NumDecodings {

    private int count;

    public static void main(String[] args) {
        NumDecodings solution = new NumDecodings();
        int i = solution.numDecodings("111111111111111111111111111111111111111111111");
        System.out.println(i);
    }

    // dp
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (Integer.parseInt(s.substring(i - 1, i)) >= 1
                    && Integer.parseInt(s.substring(i - 1, i)) <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && Integer.parseInt(s.substring(i - 2, i)) >= 10
                    && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    // 递归，超时
    public int numDecodings1(String s) {
        search(s);
        return count;
    }

    private void search(String leftString) {
        if (leftString.length() == 0) {
            count++;
            return;
        }
        if (Integer.parseInt(leftString.substring(0, 1)) >= 1 && Integer.parseInt(leftString.substring(0, 1)) <= 9) {
            search(leftString.substring(1));
        }
        if (leftString.length() >= 2 && Integer.parseInt(leftString.substring(0, 2)) >= 10
                && Integer.parseInt(leftString.substring(0, 2)) <= 26) {
            search(leftString.substring(2));
        }
    }
}