package easy;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class ExchangePosition {

    public static void main(String[] args) {
        ExchangePosition exchangePosition = new ExchangePosition();
        int[] exchange = exchangePosition.exchange(new int[]{1, 2, 3});
        for (int num : exchange) {
            System.out.println(num);
        }
    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
