package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow solution = new MaxSlidingWindow();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = new int[]{7, 2, 4};
        Arrays.stream(solution.maxSlidingWindow(nums, 3)).forEach(System.out::println);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.getFirst() < i - k + 1) {
                deque.pollFirst();
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        result[0] = max;
        for (int i = 1; i < result.length; i++) {
            if (nums[k + i - 1] >= max) {
                max = nums[k + i - 1];
                maxIndex = k + i - 1;
                nums[i] = max;
            }
            if (maxIndex > i - 1) {
                result[i] = max;
            } else {
                max = nums[i];
                maxIndex = i;
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
                result[i] = max;
            }
        }
        return result;
    }
}
