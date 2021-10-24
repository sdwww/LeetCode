/**
 * @(#)DecodeString.java, 10月 23, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 *
 * @author wangweiwei
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = decodeString.decodeString("b3[a2[c]]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        LinkedList<StringBuilder> stringStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        int num = 0;
        StringBuilder currentStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 遇到数字转化为num
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // 遇到左括号，入栈保存字符串和数字
            if (c == '[') {
                numStack.push(num);
                stringStack.push(currentStr);
                num = 0;
                currentStr = new StringBuilder();
            }
            // 遇到字符进行拼接
            if (Character.isLetter(c)) {
                currentStr.append(c);
            }
            // 遇到右括号，出栈进行拼接
            if (c == ']') {
                int popNum = numStack.pop();
                StringBuilder temp = stringStack.pop();
                for (int j = 0; j < popNum; j++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            }
        }
        return currentStr.toString();
    }
}