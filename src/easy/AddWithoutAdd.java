/**
 * @(#)AddWithoutAdd.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 *
 * @author wangweiwei
 */
public class AddWithoutAdd {

    public static void main(String[] args) {
        AddWithoutAdd solution = new AddWithoutAdd();
        int add = solution.add(7, 5);
        System.out.println(add);
    }

    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int temp = (a & b) << 1;  // temp = 进位
            a = a ^ b; // a = 非进位和
            b = temp; // b = 进位
        }
        return a;
    }
}