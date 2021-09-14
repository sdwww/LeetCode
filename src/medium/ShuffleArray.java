package medium;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 384. 打乱数组
 *
 * @author wangweiwei
 */
public class ShuffleArray {

    public static void main(String[] args) {
        ShuffleArray solution = new ShuffleArray(new int[]{1, 2, 3, 4});
        for (int i = 0; i < 10000; i++) {
            int[] shuffle = solution.shuffle();
            IntStream.of(shuffle).forEach(System.out::print);
            System.out.println();
            int[] reset = solution.reset();
            IntStream.of(reset).forEach(System.out::print);
            System.out.println();
        }
    }

    private final int[] origin;
    private final int[] snapshot;


    public ShuffleArray(int[] nums) {
        origin = nums;
        snapshot = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < snapshot.length; i++) {
            swap(snapshot, i, random.nextInt(snapshot.length - i) + i);
        }
        return snapshot;
    }

    private void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}