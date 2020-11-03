package medium;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class SingleNumbers {

    public static void main(String[] args) {
        SingleNumbers singleNumbers = new SingleNumbers();
        int[] nums = new int[]{1, 2, 10, 4, 1, 4, 3, 3};
//        int[] nums = new int[]{4, 1, 4, 6};

        Arrays.stream(singleNumbers.singleNumbers(nums)).forEach(System.out::println);
    }

    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        int compare = 1;
        while ((compare & a) != compare) {
            compare *= 2;
        }
        int b = 0;
        int c = 0;
        for (int num : nums) {
            if ((compare & num) > 0) {
                b ^= num;
            } else {
                c ^= num;
            }
        }
        result[0] = b;
        result[1] = c;
        return result;
    }
}
