package hard;

import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author www
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 0, 3, 2, 5};
//        int[] nums = new int[]{2, 3, 4, 5};
        LargestRectangleArea area = new LargestRectangleArea();
        int i = area.largestRectangleArea(nums);
        System.out.println(i);
    }

    // 单调栈
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            // 当当前元素小于栈里面的元素，出栈并且计算面积
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int j = stack.pop();
                // 如果出栈之后为空，说明所有元素都大于等于heights[j]
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int curArea = width * heights[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        // 处理存在栈里面的数据
        while (!stack.isEmpty()) {
            int j = stack.pop();
            // 如果出栈之后为空，说明所有元素都大于等于heights[j]
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            int curArea = width * heights[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

}