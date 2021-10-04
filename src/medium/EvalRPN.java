/**
 * @(#)EvalRPN.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 *
 * @author wangweiwei
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvalRPN evalRPN = new EvalRPN();
        int i = evalRPN.evalRPN(tokens);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop1 + pop2);
            } else if ("-".equals(token)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2 - pop1);
            } else if ("*".equals(token)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop1 * pop2);
            } else if ("/".equals(token)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2 / pop1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}