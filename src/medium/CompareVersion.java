/**
 * @(#)CompareVersion.java, 8月 30, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 165. 比较版本号
 *
 * @author www
 */
public class CompareVersion {

    public static void main(String[] args) {
        CompareVersion solution = new CompareVersion();
        int i = solution.compareVersion("1", "1.1");
        System.out.println(i);
    }

    public int compareVersion(String version1, String version2) {

        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        // 对齐，不够的补零
        for (int i = 0; i < Math.max(strings1.length, strings2.length); i++) {
            int num1 = i >= strings1.length ? 0 : Integer.parseInt(strings1[i]);
            int num2 = i >= strings2.length ? 0 : Integer.parseInt(strings2[i]);
            if (num1 > num2) {
                return 1;
            }
            if (num2 > num1) {
                return -1;
            }
        }
        return 0;
    }
}