/**
 * @(#)MaximumProduct.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 *
 * @author wangweiwei
 */
public class MaximumProduct {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 3, 4};
        MaximumProduct solution = new MaximumProduct();
        int i = solution.maximumProduct(nums);
        System.out.println(i);
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        // 如果均为非正数或者非负数，右边三个为最大值
        // 如果既有负数也有正数，有两种可能
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }
}