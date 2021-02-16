package easy;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2021 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2021/2/16 15:47
 * Description:561. 数组拆分 I
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        ArrayPairSum arrayPairSum = new ArrayPairSum();
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum.arrayPairSum(nums));

    }

    /**
     * 一个朴素（贪心）的理解：
     *
     * 假设排完序的结果为a1<=b1<=a2<=b2<=...<=an<=bn
     * 那么a1应该跟谁一组呢？
     *
     * a1作为全局最小值，无论跟谁一组a1都会被累加进答案，
     * 相反，a1的搭档会被永久排除。
     * 既然如此，莫不如排除一个较小的数，即给a1找一个“最小的搭档”b1。
     *
     * 当a1、b1被处理之后，a2同理分析。
     * 所以，最终选择a1,a2,...,an会得到最好的结果。
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
