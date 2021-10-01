package medium;

/**
 * 1884. 鸡蛋掉落-两枚鸡蛋
 */
public class TwoEggDrop {

    public static void main(String[] args) {
        TwoEggDrop twoEggDrop = new TwoEggDrop();
        int i = twoEggDrop.twoEggDrop(100);
        System.out.println(i);
    }

    public int twoEggDrop(int n) {
        int result = 1;
        int sum = 0;
        while (true) {
            sum += result;
            if (sum >= n) {
                return result;
            }
            result++;
        }
    }

    public int twoEggDrop1(int n) {
        return (int) Math.ceil((Math.sqrt(8 * n + 1) - 1) / 2);
    }
}
