package medium;

/**
 * 556. 下一个更大元素 III
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();
        int i = solution.nextGreaterElement(230241);
        System.out.println(i);
    }

    public int nextGreaterElement(int n) {
        String string = String.valueOf(n);
        int[] nums = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            nums[i] = string.charAt(i) - '0';
        }
        return nextPermutation(nums);
    }

    public int nextPermutation(int[] nums) {
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
        } else {
            return -1;
        }
        reverse(nums, i + 1, nums.length - 1);
        long result = 0;
        for (int num : nums) {
            result = result * 10 + num;
        }
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) result;
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
