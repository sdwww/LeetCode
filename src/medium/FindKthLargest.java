package medium;

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
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k && priorityQueue.element() <= num) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.element();
    }

    // 快速排序，从大到小排序，时间复杂度O(n)
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k-1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int start, int end, int index) {
        if (start >= end) {
            return;
        }
        int partition = partition(nums, start, end);
        if (partition > index) {
            quickSort(nums, start, partition - 1, index);
        }
        if (partition < index) {
            quickSort(nums, partition + 1, end, index);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left != right) {
            while (left < right && nums[right] < pivot) {
                right--;
            }
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            if (left != right) {
                swap(left, right, nums);
            }
        }
        swap(left, start, nums);
        return left;
    }


    // 手动实现最小堆,时间复杂度O(nlog(k))，空间复杂度O(log(k))(递归栈空间）
    public int findKthLargest2(int[] nums, int k) {
        // 构建堆
        for (int i = k - 1; i >= 0; i--) {
            adjust(nums, k, i);
        }
        // 调整堆
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                adjust(nums, k, 0);
            }
        }
        return nums[0];
    }


    private void adjust(int[] nums, int length, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxIndex = index;
        if (left < length && nums[left] < nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && nums[right] < nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            swap(index, maxIndex, nums);
            adjust(nums, length, maxIndex);
        }
    }

    private void swap(int source, int target, int[] minHeap) {
        int temp = minHeap[source];
        minHeap[source] = minHeap[target];
        minHeap[target] = temp;
    }
}
