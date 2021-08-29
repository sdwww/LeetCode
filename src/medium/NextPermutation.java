package medium;

import java.util.Arrays;

/**
 * 31. 下一个排列
 *
 * @author www
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {
        int start = 0;
        int end = 0;
        boolean find = false;
        // 倒序遍历，找到前一个数小于后一个数的地方终止
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    start = i;
                    end = j;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        // 如果找到交换两个数，第一个数位置后面的从小到大排序
        if (find) {
            swap(nums, start, end);
            Arrays.sort(nums, start + 1, nums.length);
        } // 找不到则对整个数组排序
        else {
            Arrays.sort(nums);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}