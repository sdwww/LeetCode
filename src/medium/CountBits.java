package medium;

import java.util.stream.IntStream;

/**
 * 338. 比特位计数
 */
public class CountBits {

    public static void main(String[] args) {
        CountBits solution = new CountBits();
        IntStream.of(solution.countBits(5)).forEach(System.out::println);
    }

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 1) {
                bits[i] = bits[i / 2] + 1;
            } else {
                bits[i] = bits[i / 2];
            }
        }
        return bits;
    }

    public int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = i;
            int count = 0;
            while (temp >= 1) {
                if (temp % 2 == 1) {
                    count++;
                }
                temp /= 2;
            }
            bits[i] = count;
        }
        return bits;
    }
}
