package medium;

import java.util.LinkedList;

/**
 * 946. 验证栈序列
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
//        int[] popped = new int[]{5, 4, 1, 2, 3};
        int[] popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(validateStackSequences.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedIndex = 0;
        int poppedIndex = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (pushedIndex < pushed.length) {
            stack.push(pushed[pushedIndex++]);
            while (!stack.isEmpty() && stack.getFirst().equals(popped[poppedIndex])) {
                stack.pop();
                poppedIndex++;
            }
        }
        while (!stack.isEmpty() && stack.getFirst().equals(popped[poppedIndex])) {
            stack.pop();
            poppedIndex++;
        }
        return popped.length == poppedIndex;
    }
}
