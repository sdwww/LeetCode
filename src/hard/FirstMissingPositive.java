package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = new int[]{3, 5, 2, 1};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }

    // 置换,时间复杂度O(n),空间复杂度O(1)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int j;
        for (j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return j + 1;
    }

    // hash,时间复杂度O(n),空间复杂度O(n)
    public int firstMissingPositiveHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
