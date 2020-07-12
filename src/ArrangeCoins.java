/**
 * 441. 排列硬币
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        ArrangeCoins solution = new ArrangeCoins();
        System.out.println(solution.arrangeCoins(2147483647));
    }

    public int arrangeCoins(int n) {
        int i = 0;
        int count = 0;
        while ((count + i < n) && (count + i >= 0)) {
            i++;
            count += i;
        }
        return i;
    }
}
