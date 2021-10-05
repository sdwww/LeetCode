package easy;

/**
 * @date 2020/8/9 9:30
 * Description:202. 快乐数
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(19));
    }

    // 快慢指针
    public boolean isHappy(int n) {
        int fast = trans(trans(n));
        int slow = trans(n);
        while (fast != slow) {
            fast = trans(trans(fast));
            slow = trans(slow);
        }
        return fast == 1;
    }

    private int trans(int n) {
        int num = 0;
        while (n > 0) {
            num += Math.pow(n % 10, 2);
            n /= 10;
        }
        return num;
    }
}
