package medium;

/**
 * 162. 寻找峰值
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1, 2, 6, 4, 3, 2, 1};
        int peakElement = findPeakElement.findPeakElement(nums);
        System.out.println(peakElement);
    }

    // 时间复杂度O(log(n))
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度O(n)
    public int findPeakElementSlow(int[] nums) {
        if (nums.length <= 1 || nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
