package easy;

/**
 * 231. 2的幂
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        IsPowerOfTwo solution = new IsPowerOfTwo();
        System.out.println(solution.isPowerOfTwo2(2));
    }

    /**
     * 循环乘2
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {

        int num = 1;
        while (num < n && num > 0) {
            num *= 2;
        }
        return num == n;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        int maxNum = (int) Math.pow(2, 30);
        return maxNum % n == 0;

    }
}
