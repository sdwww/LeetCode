package medium;

import java.util.Arrays;

/**
 * @date 2020/8/15 11:01
 * Description:611. 有效三角形的个数
 */
public class TriangleNumber {

    public static void main(String[] args) {
        TriangleNumber solution = new TriangleNumber();
        int[] array = {1, 2, 3, 4,6};
        System.out.println(solution.triangleNumber(array));
    }

    // 暴力
    public int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (nums[j] + nums[k] > nums[i]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            int j = i - 1;
            int k = 0;
            while (j > k) {
                if (nums[j] + nums[k] > nums[i]) {
                    count += j - k;
                    j--;
                } else {
                    k++;
                }
            }

        }
        return count;
    }
}
