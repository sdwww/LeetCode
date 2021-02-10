package medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class MinArray {


    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
