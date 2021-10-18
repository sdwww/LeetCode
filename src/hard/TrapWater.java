package hard;

/**
 * 42. 接雨水
 */
public class TrapWater {

    public static void main(String[] args) {
        TrapWater trapWater = new TrapWater();
//        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trapWater.trap(nums));

    }

    // 双指针，时间复杂度O(n)，空间复杂度O(1)
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int result = 0;
        while (left < right) {
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);
            if (maxLeft > maxRight) {
                result += maxRight - height[right];
                right--;
            } else {
                result += maxLeft - height[left];
                left++;
            }
        }
        return result;
    }

    // 根据木桶效应，从左到右和从右到左找当前节点两边最大值的最小值，时间复杂度O(n)，空间复杂度O(n)
    public int trapArray(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int total = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = left.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < left.length; i++) {
            total += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return total;
    }

    // 每一个节点的左右最高点的最小值，时间复杂度O(n2),空间复杂度O(1)
    public int trapLeftRight(int[] height) {
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > left) {
                    left = height[j];
                }
            }
            for (int j = i; j < height.length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }
            total += Math.max(0, Math.min(left, right) - height[i]);
        }
        return total;
    }
}
