package hard;

import java.util.LinkedList;

/**
 * 85. 最大矩形
 *
 * @author www
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] nums = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = maximalRectangle.maximalRectangle(nums);
        System.out.println(i);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[] sum = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == '1') {
                    sum[j] += 1;
                } else {
                    sum[j] = 0;
                }
            }
            max = Math.max(largestRectangleArea(sum), max);
        }
        return max;
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