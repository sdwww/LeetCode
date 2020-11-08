package medium;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] arr = {1,2,1,0,1, 2};
        solution.sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }


    public void sortColors(int[] nums) {
        int count;
        do {
            count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    count++;
                }
            }
        } while (count > 0);
    }
}
