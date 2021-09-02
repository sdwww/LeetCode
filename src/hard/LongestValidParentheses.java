package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses solution =new LongestValidParentheses();
        int i = solution.longestValidParentheses("()()()()");
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        // 栈底是最后一个没有被匹配的右括号的下标
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
