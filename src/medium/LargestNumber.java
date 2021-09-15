package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 179. 最大数
 *
 * @author wangweiwei
 */
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        int[] arr = {0, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(arr));
    }

    public String largestNumber(int[] nums) {

        String string = IntStream.of(nums)
                .mapToObj(String::valueOf)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .reduce(String::concat)
                .orElse("0");

        // 单独处理多个0的情况
        if (string.charAt(0) == '0') {
            return "0";
        }
        return string;
    }
}