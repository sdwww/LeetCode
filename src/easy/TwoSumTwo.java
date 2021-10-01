/**
 * @(#)TwoSumTwo.java, 10月 01, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author wangweiwei
 */
public class TwoSumTwo {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        TwoSumTwo twoSumTwo = new TwoSumTwo();
        int[] ints = twoSumTwo.twoSum(nums, 13);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    // 双指针，时间复杂度O(n)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            } else if (target > numbers[left] + numbers[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}