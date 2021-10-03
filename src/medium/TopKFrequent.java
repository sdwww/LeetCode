/**
 * @(#)TopKFrequent.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. 前K个高频单词
 *
 * @author wangweiwei
 */
public class TopKFrequent {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        TopKFrequent solution = new TopKFrequent();
        List<String> list = solution.topKFrequent(words, 4);
        System.out.println(list);
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 1.先放到map，key是word，value是次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 2.定义WordAndFrequent，将map转换到最小堆中
        PriorityQueue<WordAndFrequent> queue = new PriorityQueue<>(k);
        for (String word : map.keySet()) {
            queue.offer(new WordAndFrequent(word, map.get(word)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> result = new ArrayList<>(k);
        // 3.转换到结果中
        while (!queue.isEmpty()) {
            result.add(0,queue.poll().string);
        }
        return result;
    }
}

class WordAndFrequent implements Comparable<WordAndFrequent> {
    /**
     * 单词
     */
    String string;
    /**
     * 频率
     */
    Integer frequent;

    public WordAndFrequent(String string, Integer frequent) {
        this.string = string;
        this.frequent = frequent;
    }

    // 优先对比频率，其次对比string
    @Override
    public int compareTo(WordAndFrequent o) {
        int compareFrequent = this.frequent.compareTo(o.frequent);
        if (compareFrequent == 0) {
            return o.string.compareTo(this.string);
        }
        return compareFrequent;
    }
}