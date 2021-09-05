/**
 * @(#)GetLeastNumbers.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * @author wangweiwei
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers solution = new GetLeastNumbers();
        int[] nums = new int[]{0, 1, 2, 1, 4, 5, 6};
        int[] leastNumbers = solution.getLeastNumbers(nums, 2);
        IntStream.of(leastNumbers).forEach(System.out::println);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        // 最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1, (x, y) -> y - x);
        for (int num : arr) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}