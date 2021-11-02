package easy;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicatesArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesArray solution = new RemoveDuplicatesArray();
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    // 双指针
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
