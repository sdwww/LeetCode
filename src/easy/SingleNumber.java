package easy;

/**
 * 136. 只出现一次的数字
 *
 * @author www
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int i = singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }

    /**
     * 异或
     *
     * @param nums 数组
     * @return 出现一次的数
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}