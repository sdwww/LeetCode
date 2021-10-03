/**
 * @(#)StringPermutation.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * @author wangweiwei
 */
public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation solution = new StringPermutation();
        String[] permutation = solution.permutation("aab");
        for (String s : permutation) {
            System.out.println(s);
        }
    }

    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[s.length()];
        dfs(chars, used, new StringBuilder(), result);
        return result.toArray(new String[0]);
    }

    private void dfs(char[] chars, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 去重逻辑，优先使用第一个，后面的跳过
            if (used[i] || (i > 0 && !used[i - 1] && chars[i - 1] == chars[i])) {
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            dfs(chars, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}