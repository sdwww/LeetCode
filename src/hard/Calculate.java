/**
 * @(#)Calculate.java, 9月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package hard;

import java.util.LinkedList;

/**
 * 224. 基本计算器
 *
 * @author wangweiwei
 */
public class Calculate {

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        int calculate1 = calculate.calculate("- (3 + (4 + 5))");
        System.out.println(calculate1);
    }

    public int calculate(String s) {
        // 栈顶记录当前符号,很巧妙的去括号做法，例如-（1+2）变成 -1-2
        LinkedList<Integer> sign = new LinkedList<>();
        // 默认为正
        sign.push(1);

        int result = 0, num = 0, operator = 1;
        for (char ch : s.toCharArray()) {
            //取出完整数值//空格可以不管，直接忽略
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                continue;
            }

            // 计算一个运算符
            result += operator * num;
            // 数值清空
            num = 0;

            if (ch == '+') {
                operator = sign.peek();
            } else if (ch == '-') {
                operator = -sign.peek();
            } else if (ch == '(') {
                // 进入左括号，把左括号之前的符号置于栈顶
                sign.push(operator);
            } else if (ch == ')') {
                // 退出括号，弹出栈顶符号
                sign.pop();
            }
        }

        // 计算最后一个数
        result += operator * num;

        return result;
    }
}