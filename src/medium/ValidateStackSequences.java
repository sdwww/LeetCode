package medium;

import java.util.LinkedList;

/**
 * 946. 验证栈序列
 * 剑指 Offer 31. 栈的压入、弹出序列
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        ValidateStackSequences solution = new ValidateStackSequences();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
//        int[] popped = new int[]{5, 4, 1, 2, 3};
        int[] popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(solution.validateStackSequences(pushed, popped));
    }

    // 模拟
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIndex = 0;
        int popIndex = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (pushIndex < pushed.length) {
            stack.push(pushed[pushIndex++]);
            while (!stack.isEmpty() && stack.peek().equals(popped[popIndex])) {
                stack.pop();
                popIndex++;
            }
        }
        while (!stack.isEmpty() && stack.peek().equals(popped[popIndex])) {
            stack.pop();
            popIndex++;
        }
        return popped.length == popIndex;
    }
}
