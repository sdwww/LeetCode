package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-2, 0, 0, 2, 2};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(nums));
    }

    /**
     * 暴力方法，超时
     *
     * @param nums 入参
     * @return 三元组列表
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 1.进行排序
        Arrays.sort(nums);
        // 2.两层循环，双指针求和等于-nums[i],进一步优化：nums[i] <= 0
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 3.跳过重复元素，当num[i]不重复时，三元组仍然可能重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    // 4.循环到和之前不一致的数值，避免重复三元组的出现
                    do {
                        j++;
                    }
                    while (j < k && nums[j] == nums[j - 1]);
                    do {
                        k--;
                    }
                    while (j < k && nums[k] == nums[k + 1]);
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        return lists;
    }

    /**
     * 暴力方法，超时
     *
     * @param nums 入参
     * @return 三元组列表
     */
    public List<List<Integer>> threeSumBf(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 1.进行排序
        Arrays.sort(nums);
        // 2.三层循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // 3.因为数组排序了，如果第一个大于0或者最后一个小于0直接返回
                    if (nums[i] > 0 || nums[k] < 0) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        // 4.去重
                        if (!lists.contains(list)) {
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }
}
