package medium;

/**
 * 1492. n 的第 k 个因子
 */
public class KthFactor {

    public static void main(String[] args) {
        KthFactor solution = new KthFactor();
        System.out.println(solution.kthFactor(4, 4));
    }

    public int kthFactor(int n, int k) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (count == k) {
                    return i;
                } else {
                    count++;
                }
            }
        }
        return -1;
    }
}
