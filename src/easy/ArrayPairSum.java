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

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
