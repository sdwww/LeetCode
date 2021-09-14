package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 349. 两个数组的交集
 *
 * @author wangweiwei
 */
public class Intersection {

    public static void main(String[] args) {
        Intersection solution = new Intersection();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};

        int[] intersection = solution.intersection(nums1, nums2);
        IntStream.of(intersection).forEach(System.out::println);
    }

    // 时间复杂度O(nlog(n))
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1) {
            if (binarySearch(num, nums2) >= 0) {
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private int binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}