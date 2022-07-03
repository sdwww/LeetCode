package easy;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare solution = new IsPerfectSquare();
        System.out.println(solution.isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num; i++) {
            if (i * i == num) {
                return true;
            }
            if (i * i < 0 || i * i > num) {
                return false;
            }
        }
        return false;
    }

}
