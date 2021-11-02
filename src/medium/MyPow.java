package medium;

/**
 * 50. Pow(x, n)
 */
public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2, -2);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        double result1 = myPow(x, n / 2);
        double result2 = myPow(x, n % 2);
        return result1 * result1 * result2;
    }
}
