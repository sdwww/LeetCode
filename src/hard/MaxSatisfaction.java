package hard;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 */
public class MaxSatisfaction {

    public static void main(String[] args) {
        MaxSatisfaction maxSatisfaction = new MaxSatisfaction();
        int[] nums = new int[]{-1, -8, 0, 5, -9};
        int i = maxSatisfaction.maxSatisfaction(nums);
        System.out.println(i);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0, max = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (sum + satisfaction[i] > 0) {
                sum += satisfaction[i];
                max += sum;
            } else {
                break;
            }
        }
        return max;
    }

    public int maxSatisfaction1(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int sum = 0;
            for (int j = i; j < satisfaction.length; j++) {
                sum += (j - i + 1) * satisfaction[j];
            }
            if (sum > max) {
                max = sum;
            }
            if (satisfaction[i] > 0) {
                break;
            }
        }
        return max;
    }
}
