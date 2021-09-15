package easy;

import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * @author wangweiwei
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        String s = removeDuplicates.removeDuplicates("abbaca");
        System.out.println(s);
    }

    // 对称问题使用栈
    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }
        return stringBuilder.toString();
    }
}