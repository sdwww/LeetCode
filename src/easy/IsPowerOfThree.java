package easy;

/**
 * 326. 3的幂
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        IsPowerOfThree solution = new IsPowerOfThree();
        System.out.println(solution.isPowerOfThree(27));
    }

    /**
     * 循环乘3
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        int num = 1;
        while (num < n && num > 0) {
            num *= 3;
        }
        return num == n;
    }
}
