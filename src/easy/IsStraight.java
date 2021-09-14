package easy;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 *
 * @author wangweiwei
 */
public class IsStraight {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 6};
        IsStraight isStraight = new IsStraight();
        boolean straight = isStraight.isStraight(nums);
        System.out.println(straight);
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // 计算0的数量
        int zeroCount = 0;
        int different = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                zeroCount = i;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            // 忽略0的情况
            if (nums[i - 1] == 0) {
                continue;
            }
            // 有重复的牌必然不是顺子
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            different += nums[i] - nums[i - 1] - 1;
        }
        return different <= zeroCount;
    }
}