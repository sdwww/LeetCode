package easy;

/**
 * 268. 丢失的数字
 *
 * @author wangweiwei
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = new int[]{0, 1};
        int i = missingNumber.missingNumber(nums);
        System.out.println(i);
    }

    // 数学方法
    public int missingNumber(int[] nums) {
        int expectSum = (1 + nums.length) * nums.length / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return expectSum - sum;
    }
}