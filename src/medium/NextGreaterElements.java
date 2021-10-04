/**
 * @(#)NextGreaterElements.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 *
 * @author wangweiwei
 */
public class NextGreaterElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        NextGreaterElements solution = new NextGreaterElements();
        int[] ints = solution.nextGreaterElements(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] nextGreaterElements(int[] nums) {

        // 构建一个两倍长度的nums
        int[] twoNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            twoNums[i] = nums[i];
            twoNums[i + nums.length] = nums[i];
        }

        // 结果，赋值为-1
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        // 单调栈
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < twoNums.length; i++) {
            while (!stack.isEmpty() && twoNums[i] > twoNums[stack.peek()]) {
                int index = stack.pop() % nums.length;
                result[index] = twoNums[i];
            }
            stack.push(i);
        }
        return result;
    }
}