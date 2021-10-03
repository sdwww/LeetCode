/**
 * @(#)KthLargest.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 * @author wangweiwei
 */
public class KthLargest {

    private final PriorityQueue<Integer> priorityQueue;

    private final int capacity;

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        capacity = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > capacity) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}