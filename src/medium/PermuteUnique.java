package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2018-2020 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2020/8/9 15:04
 * Description:47. 全排列 II
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique solution = new PermuteUnique();
        int[] arr = {1, 2, 3};
        System.out.println(solution.permuteUnique(arr));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(lists, list, used, nums);
        return lists;
    }

    private void generate(List<List<Integer>> lists, List<Integer> list, boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]&&!isExist(used,nums,i)) {
                used[i] = true;
                List<Integer> listTemp = new ArrayList<>(list);
                listTemp.add(nums[i]);
                generate(lists, listTemp, used, nums);
                used[i] = false;
            }

        }
    }

    private boolean isExist(boolean[] used, int[] nums, int index) {
        for (int i = 0; i < used.length; i++) {
            if (i > index && used[i] && nums[index] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
