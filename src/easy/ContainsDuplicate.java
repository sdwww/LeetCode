package easy;

import java.util.HashSet;

/**
 * 217. 存在重复元素
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(solution.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        return hashSet.size() != nums.length;
    }
}
