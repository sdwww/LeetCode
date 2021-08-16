package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @author www
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int longestConsecutive = 0;
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        for (Integer item : set) {
            if (set.contains(item - 1)) {
                continue;
            }
            int currentItem = item;
            int currentConsecutive = 1;
            while (set.contains(currentItem + 1)) {
                currentConsecutive++;
                currentItem++;
            }
            longestConsecutive = Math.max(currentConsecutive, longestConsecutive);
        }
        return longestConsecutive;
    }
}