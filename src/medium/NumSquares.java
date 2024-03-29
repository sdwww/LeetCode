package medium;

/**
 * @date 2020/8/9 19:30
 * Description:279. 完全平方数
 */
public class NumSquares {
    private int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        NumSquares solution = new NumSquares();
        // 25+16+1+1  16+16+9+3 36+4+1+1+1  25+9+9
        System.out.println(solution.numSquares(43));
    }

    // 动态规划
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
            for (int j = 0; i - j * j >= 0; j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
            }
        }
        return arr[n];
    }

    // 递归
    public int numSquares1(int n) {
        int count = 0;
        int max = (int) Math.sqrt(n);
        for (int i = max; i > 0; i--) {
            calculate(n, count, i);
        }
        return minCount;
    }

    private void calculate(int left, int count, int currentStep) {
        if (left <= 3 || count >= minCount) {
            if (count + left < minCount) {
                minCount = count + left;
            }
            return;
        }
        int sqrt = (int) Math.sqrt(left);
        count++;
        for (int i = Math.min(sqrt, currentStep); i > 0; i--) {
            calculate(left - i * i, count, i);
        }
    }
}
