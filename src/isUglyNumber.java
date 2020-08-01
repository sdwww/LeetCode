/**
 * 263. 丑数
 */
public class isUglyNumber {

    public static void main(String[] args) {
        isUglyNumber solution = new isUglyNumber();
        System.out.println(solution.isUgly(Integer.MAX_VALUE));
    }

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num >>= 1;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
