/**
 * @(#)ReverseInteger.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 7. 整数反转
 *
 * @author wangweiwei
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int reverse = solution.reverse(-2147483648);
        System.out.println(reverse);
        System.out.println(Integer.MAX_VALUE);
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean positive = true;
        if (x < 0) {
            positive = false;
        }
        x = Math.abs(x);
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + mod;
        }
        return positive ? result : -result;
    }
}