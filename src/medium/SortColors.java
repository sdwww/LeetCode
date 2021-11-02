package medium;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] arr = {1, 2, 1, 0, 1, 2};
        solution.sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 从左往右遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
        }
        // 从右往左遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            }
        }
    }

    // 冒泡排序，时间复杂度O(n2)
    public void sortColors1(int[] nums) {
        int count;
        do {
            count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    count++;
                }
            }
        } while (count > 0);
    }

    private void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}
