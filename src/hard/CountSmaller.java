/**
 * @(#)CountSmaller.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 315. 计算右侧小于当前元素的个数
 *
 * @author wangweiwei
 */
public class CountSmaller {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> list = countSmaller.countSmaller(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println(list);
    }

    private int[] index;
    private int[] helper;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        index = new int[nums.length];
        helper = new int[nums.length];
        count = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        merge(nums, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            res.add(i, count[i]);
        }
        return res;
    }

    private void merge(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;

        if (start < mid) {
            merge(nums, start, mid);
        }

        if (mid + 1 < end) {
            merge(nums, mid + 1, end);
        }

        int i = start, j = mid + 1;
        int hi = start;
        while (i <= mid && j <= end) {
            if (nums[index[i]] <= nums[index[j]]) {
                // 右侧出
                helper[hi++] = index[j++];
            } else {
                // 左侧出 计数
                count[index[i]] += end - j + 1;
                helper[hi++] = index[i++];
            }
        }

        while (i <= mid) {
            //左侧出
            helper[hi++] = index[i++];
        }

        while (j <= end) {
            // 右侧出
            helper[hi++] = index[j++];
        }

        for (int k = start; k <= end; k++) {
            index[k] = helper[k];
        }
    }
}