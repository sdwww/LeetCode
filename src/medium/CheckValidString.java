/**
 * @(#)CheckValidString.java, 9月 19, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.LinkedList;

/**
 * 678. 有效的括号字符串
 *
 * @author wangweiwei
 */
public class CheckValidString {

    public static void main(String[] args) {
        CheckValidString solution = new CheckValidString();
        boolean b = solution.checkValidString("((");
        System.out.println(b);
    }

    public boolean checkValidString(String s) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.push(i);
            } else if (c == '*') {
                stack2.push(i);
            } else {
                // 遇到')'，优先stack1出栈，其次stack2出栈，否则返回false
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }
        // *当做')'或者空使用
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Integer index1 = stack1.pop();
            Integer index2 = stack2.pop();
            if (index1 > index2) {
                return false;
            }
        }
        return stack1.isEmpty();
    }
}