/**
 * @(#)RemoveDuplicateLetters.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.LinkedList;

/**
 * 316. 去除重复字母
 *
 * @author wangweiwei
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        String s = solution.removeDuplicateLetters("bcabc");
        System.out.println(s);
    }

    public String removeDuplicateLetters(String s) {
        // 栈顶是最小值
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果已经包含该字符，跳过
            if (stack.contains(c)) {
                continue;
            }
            // 如果当前字符小于栈顶元素，并且栈顶元素后面还有，栈顶元素出栈
            while (!stack.isEmpty() && c < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        // 将栈的信息转换到string中
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}