package easy;

/**
 * 69. x 的平方根
 */
public class MySqrt {

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(1));
    }


    public int mySqrt(int x) {
        int left = 0, right = x;
        int mid;
        int result = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
