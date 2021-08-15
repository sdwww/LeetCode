package easy;

import java.util.stream.IntStream;

/**
 * 283. 移动零
 *
 * @author www
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] array = {0, 1, 0, 3, 12};
        solution.moveZeroes(array);
        IntStream.of(array).forEach(System.out::println);
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    // 类似冒泡排序
    public void moveZeroes1(int[] nums) {
        while (true) {
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] != 0) {
                    swap(nums, i, i + 1);
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}