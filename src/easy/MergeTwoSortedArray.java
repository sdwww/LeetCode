package easy;

/**
 * 88. 合并两个有序数组
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
        int[] nums = {2, 0};
        mergeTwoSortedArray.merge(nums, 1, new int[]{1}, 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 时间复杂度O(m+n),空间复杂度O（1）
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 数组1的索引值
        int p1 = m - 1;
        // 数组2的索引值
        int p2 = n - 1;
        // 合并之后的索引值
        int p3 = m + n - 1;
        while (p2 >= 0) {
            // 考虑num1为空的情况
            if (p1 < 0 || nums1[p1] < nums2[p2]) {
                nums1[p3--] = nums2[p2--];
            } else {
                nums1[p3--] = nums1[p1--];
            }
        }
    }
}
