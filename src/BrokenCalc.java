/**
 * 991. 坏了的计算器
 */
public class BrokenCalc {

    public static void main(String[] args) {
        BrokenCalc solution = new BrokenCalc();
        System.out.println(solution.brokenCalc(10, 16));
    }

    public int brokenCalc(int X, int Y) {
        if (Y <= X) {
            return X - Y;
        }
        int count = 0;
        while (Y > X) {
            count++;
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y >>= 1;
            }
        }
        return count + X - Y;
    }
}
