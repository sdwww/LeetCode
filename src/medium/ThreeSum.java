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

    // 时间复杂度O(n2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1.进行排序
        Arrays.sort(nums);
        // 2.两层循环
        for (int i = 0; i < nums.length; i++) {
            // 大于0直接返回
            if (nums[i] > 0) {
                break;
            }
            // 除了第一个元素，过滤掉重复的值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    // 第二个元素除了第一个，去重
                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
            }
        }
        return result;
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
