/**
 * @(#)FindContinuousSequence.java, 10月 01, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 *
 * @author wangweiwei
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence solution = new FindContinuousSequence();
        int[][] sequence = solution.findContinuousSequence(15);
        for (int[] ints : sequence) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right && right < target) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] nums = new int[right - left + 1];
                for (int i = 0; i < right - left + 1; i++) {
                    nums[i] = left + i;
                }
                lists.add(nums);
                right++;
            } else if (sum > target) {
                left++;
            } else {
                right++;
            }
        }
        return lists.toArray(new int[0][0]);
    }
}