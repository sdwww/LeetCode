package medium;

/**
 * @date 2020/10/4 11:29
 * Description:650. 只有两个键的键盘
 */
public class MinStepsOnlyTwoKey {

    public static void main(String[] args) {
        MinStepsOnlyTwoKey solution = new MinStepsOnlyTwoKey();
        System.out.println(solution.minSteps(1024));
    }

    public int minSteps(int n) {
        int step = 0;
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    step += i;
                    n /= i;
                    break;
                }
            }
        }
        return step;
    }
}
