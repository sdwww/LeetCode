/**
 * @(#)AddBinary.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 67. 二进制求和
 *
 * @author wangweiwei
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("11", "1");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        // 反转字符串
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        StringBuilder result = new StringBuilder();
        boolean moreThanOne = false;
        int index = 0;
        while (index < a.length() || index < b.length() || moreThanOne) {
            int o1 = index >= a.length() ? 0 : a.charAt(index) - '0';
            int o2 = index >= b.length() ? 0 : b.charAt(index) - '0';
            int sum = o1 + o2 + (moreThanOne ? 1 : 0);
            result.append(sum % 2);
            moreThanOne = sum > 1;
            index++;
        }
        return result.reverse().toString();
    }
}