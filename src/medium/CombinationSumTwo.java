/**
 * @(#)CombinationSumTwo.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author wangweiwei
 */
public class CombinationSumTwo {

    public static void main(String[] args) {
        CombinationSumTwo solution = new CombinationSumTwo();
        int[] nums = new int[]{3, 1, 3, 5, 1, 1};
        List<List<Integer>> lists = solution.combinationSum2(nums, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum(candidates, 0, 0, target, lists, new ArrayList<>());
        return lists;
    }

    public void combinationSum(int[] candidates, int sum, int index, int target, List<List<Integer>> lists, List<Integer> list) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> listCopy = new ArrayList<>(list);
            lists.add(listCopy);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combinationSum(candidates, sum + candidates[i], i + 1, target, lists, list);
            list.remove(list.size() - 1);
        }
    }
}