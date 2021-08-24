package medium;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchSpinSortArray {

    public static void main(String[] args) {
        SearchSpinSortArray solution = new SearchSpinSortArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int search = solution.search(nums, 2);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                // 有序
                if (target < nums[mid] && target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 有序
                if (target > nums[mid] && target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
