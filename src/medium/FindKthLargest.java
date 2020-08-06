package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest solution = new FindKthLargest();
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(arr, 2));
    }

    /**
     * 优先队列实现最小堆
     *
     * @param nums 所有数据
     * @param k    获取第k大
     * @return 第k大
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k && priorityQueue.element() <= num) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.element();
    }

    /**
     * 手动实现最小堆
     *
     * @param nums 所有数据
     * @param k    获取第k大
     * @return 第k大
     */
    public int findKthLargest1(int[] nums, int k) {
        int[] minHeap = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap[i] = nums[i];
        }
        Arrays.sort(minHeap);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap[0]) {
                addMinHeap(nums[i], minHeap);
            }
        }
        return minHeap[0];
    }

    /**
     * 最小堆添加节点
     *
     * @param num     数字
     * @param minHeap 最小堆
     */
    private void addMinHeap(int num, int[] minHeap) {
        minHeap[0] = num;
        int swapIndex = 0;
        while ((swapIndex * 2 + 1 < minHeap.length && minHeap[swapIndex * 2 + 1] < num)
                || (swapIndex * 2 + 2 < minHeap.length && minHeap[swapIndex * 2 + 2] < num)) {
            int nextIndex;
            if ((swapIndex * 2 + 2) >= minHeap.length || minHeap[swapIndex * 2 + 1] < minHeap[swapIndex * 2 + 2]) {
                nextIndex = swapIndex * 2 + 1;
            } else {
                nextIndex = swapIndex * 2 + 2;
            }
            swap(swapIndex, nextIndex, minHeap);
            swapIndex = nextIndex;
        }
    }

    private void swap(int index1, int index2, int[] minHeap) {
        int temp = minHeap[index1];
        minHeap[index1] = minHeap[index2];
        minHeap[index2] = temp;
    }


}
