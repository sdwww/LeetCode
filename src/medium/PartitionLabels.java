/**
 * @(#)PartitionLabels.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 763. 划分字母区间
 *
 * @author wangweiwei
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        List<Integer> list = solution.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(list);
    }

    // 时间复杂度O(n)
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        // 记录每个字符最后一次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int current = 0;
        int left = 0;
        int right = 0;
        while (current < s.length()) {
            int lastIndex = map.get(s.charAt(current));
            // 更新右边界
            right = Math.max(right, lastIndex);
            // 如果当前位置已经大于等于右边界，存储结果
            if (current >= right) {
                result.add(current - left + 1);
                left = current + 1;
            }
            current++;
        }
        return result;
    }
}