/**
 * @(#)LastRemaining.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.ArrayList;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 *
 * @author wangweiwei
 */
public class LastRemaining {

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        int i = lastRemaining.lastRemaining(10, 17);
        System.out.println(i);
    }

    // 约瑟夫环问题,模拟法
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}