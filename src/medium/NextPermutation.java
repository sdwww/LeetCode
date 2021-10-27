package medium;

/**
 * 31. 下一个排列
 *
 * @author www
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{9, 1, 4, 8, 9, 5};
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {
        // 交换的左边位置
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 交换的右边位置
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    // 时间复杂度O(n2)
    public void nextPermutation1(int[] nums) {
        int start = 0;
        int end = 0;
        boolean find = false;
        // 倒序遍历，针对每一个元素，倒序找到后面大于自己的元素终止
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
            reverse(nums, start + 1, nums.length - 1);
        } // 找不到则对整个数组倒序
        else {
            reverse(nums, 0, nums.length - 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}