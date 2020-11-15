package medium;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author www
 * Description:剑指 Offer 45. 把数组排成最小的数
 * @date 2020/10/4 12:11
 */
public class MinNumberForArray {

    public static void main(String[] args) {
        MinNumberForArray solution = new MinNumberForArray();
        int[] arr = {3, 30, 34, 5, 9};
//        int[] arr = {12, 121};
        System.out.println(solution.minNumber(arr));
    }

    public String minNumber(int[] nums) {
        return IntStream.of(nums).mapToObj(String::valueOf).sorted((a, b) -> (a + b).compareTo((b + a))).collect(Collectors.joining());
    }


    public String minNumber1(int[] nums) {
        int swapCount = 1;
        while (swapCount > 0) {
            swapCount = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (compareTo(nums[i], nums[i + 1]) > 0) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapCount++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private int compareTo(int m, int n) {
        String mStr = String.valueOf(m);
        String nStr = String.valueOf(n);
        return (mStr + nStr).compareTo(nStr + mStr);
    }
}
