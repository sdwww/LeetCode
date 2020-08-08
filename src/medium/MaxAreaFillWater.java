package medium;

/**
 * 11. 盛最多水的容器
 */
public class MaxAreaFillWater {

    public static void main(String[] args) {
        MaxAreaFillWater solution = new MaxAreaFillWater();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(arr));
    }

    public int maxArea(int[] height) {
        int first = 0;
        int end = height.length - 1;
        int maxArea = 0;
        do {
            int area = Math.min(height[first], height[end]) * (end - first);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[first] > height[end]) {
                end--;
            } else {
                first++;
            }
        } while (first < end);
        return maxArea;
    }
}
