package hard;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * <p>
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class MinArray2 {

    public static void main(String[] args) {
        MinArray2 minArray = new MinArray2();
        System.out.println(minArray.findMin(new int[]{3, 3, 3, 1, 3}));
    }

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
