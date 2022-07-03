package medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class MinArray {


    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.findMin(new int[]{2, 1}));
    }

    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // nums[mid]可能为nums[0],但是nums[0]不可能为结果
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
