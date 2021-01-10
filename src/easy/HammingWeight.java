package easy;

/**
 * 191. 位1的个数
 */
public class HammingWeight {

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(-1));

    }

    public int hammingWeight(int n) {
        if (n >= 0) {
            return countge0(n);
        } else {
            n = Math.abs(n) - 1;
            return 32 - countge0(n);
        }
    }

    private int countge0(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }
}
