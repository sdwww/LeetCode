package medium;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = new int[]{5, 7, 8, 8, 8, 10};
        int[] ints = searchRange.searchRange(nums, 8);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchRange(nums, target, true);
        result[1] = searchRange(nums, target, false);
        return result;
    }

    public int searchRange(int[] nums, int target, boolean isLeft) {
        int result = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                result = mid;
                if (isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return result;
    }
}
